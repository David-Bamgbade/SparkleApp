package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.data.Repository.LaundererMarketRepository;
import com.SparkleApp.data.Repository.LaundererRepository;
import com.SparkleApp.data.Repository.OrderPlacementRepository;
import com.SparkleApp.data.models.Launderer;
import com.SparkleApp.data.models.LaundryMarket;
import com.SparkleApp.data.models.OrderPlacement;
import com.SparkleApp.exception.LaundererAlreadyExistException;
import com.SparkleApp.exception.LaundererNotLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class LaundererServiceImpl implements LaundererService{

    @Autowired
    private OrderPlacementRepository orderPlacementRepository;

    @Autowired
    private LaundererRepository laundererRepository;

    @Autowired
    private LaundererMarketRepository laundererMarketRepository;

    public SignUpLaundererResponse signUp(SignUpLaundererRequest request) {
        validate(request);
        SignUpLaundererResponse response = new SignUpLaundererResponse();
        Launderer launderer = laundererRepository.findByEmailAndPhoneNumber(validateEmail(request.getEmail().toLowerCase()), validatePhoneNumber(request.getPhoneNumber()));
            if (launderer == null) {
                Launderer launderer1 = new Launderer();
                launderer1.setFirstName((validateFirstName(request.getFirstName()).toLowerCase()));
                launderer1.setLastName(validateLastName(request.getLastName()).toLowerCase());
                launderer1.setPhoneNumber(validatePhoneNumber(verifyPhoneNumber(request.getPhoneNumber())));
                launderer1.setLoggedIn(false);
                launderer1.setEmail(validateEmail(request.getEmail()).toLowerCase());
                launderer1.setPassword(validatePassword(request.getPassword()).toLowerCase());
                launderer1.setConfirmPassword(validatePassword(request.getConfirmPassword()).toLowerCase());
                launderer1.setCreatedAt(LocalDateTime.now());
                laundererRepository.save(launderer1);
            } else {
                throw new IllegalArgumentException("User already exists");
            }
        response.setMessage("Successfully signed up");
        response.setCreatedAt(LocalDateTime.now());
        return response;
    }

    @Override
    public LoginLaundererResponse loginLaunderer(LoginLaundererRequest request) {
         Launderer launderer = laundererRepository.findByEmailAndPassword(validateEmail(request.getEmail()).toLowerCase(), validatePassword(request.getPassword()).toLowerCase());
         if(launderer != null){
             launderer.setLoggedIn(true);
             laundererRepository.save(launderer);
         }
         else {
             throw new IllegalArgumentException("Invalid email or password");
         }
        LoginLaundererResponse response = new LoginLaundererResponse();
         response.setLoggedIn(true);
         response.setMessage("Successfully logged in");
        return response;
    }

    @Override
    public LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request) {
        LaundererReceiveResponse response = new LaundererReceiveResponse();
        OrderPlacement order = new OrderPlacement();
        order.setCustomerFirstName(validateFirstName(request.getCustomerFirstName()).toLowerCase());
        order.setCustomerLastName(validateLastName(request.getCustomerLastName()).toLowerCase());
        order.setNumberOfItems(request.getNumberOfItems());
        order.setCustomerPhoneNumber(request.getCustomerPhoneNumber());
        order.setCustomerAddress(request.getCustomerAddress().toLowerCase());
        order.setServiceDescription(request.getServiceDescription());
        order.setNameOfItems(request.getNameOfItems());
        orderPlacementRepository.save(order);
        response.setCustomerFirstName(order.getCustomerFirstName().toLowerCase());
        response.setCustomerLastName(order.getCustomerLastName().toLowerCase());
        response.setCustomerPhoneNumber(order.getCustomerPhoneNumber().toLowerCase());
        response.setCustomerAddress(order.getCustomerAddress().toLowerCase());
        response.setNameOfItems(order.getNameOfItems().toLowerCase());
        response.setNumberOfItems(order.getNumberOfItems());
        return response;
    }

    private String validateConfirmPassword(String confirmPassword){
        Launderer launderer = laundererRepository.findByPassword(validatePassword(confirmPassword));
        if(!launderer.getPassword().equals(confirmPassword)){
            throw new IllegalArgumentException("Password mismatch");
        }
        else {
            return confirmPassword;
        }
    }

    private String isExists (String email) {
        Launderer launderer = laundererRepository.findByEmail(email);
            if (launderer == null) {
                throw new RuntimeException("Launderer not found");
            }
            else {
                return launderer.getPassword();
            }
        }

    @Override
    public LaundererSendResponse laundererSendPackage(LaundererSendRequest request) {
        LaundererSendResponse response = new LaundererSendResponse();
        OrderPlacement order = new OrderPlacement();
        long orderId = order.getOrderId();
        order.setCustomerFirstName(validateFirstName(request.getCustomerFirstName()).toLowerCase());
        order.setCustomerLastName(validateLastName(request.getCustomerLastName()).toLowerCase());
        order.setCustomerPhoneNumber(validatePhoneNumber(request.getCustomerPhoneNumber()).toLowerCase());
        order.setCustomerAddress(validateAddress(request.getCustomerAddress()).toLowerCase());
        order.setTotalServicePrice(request.getTotalPrice());
        order.setPaymentStatus(request.isPaymentStatus());
        order.setNumberOfItems(request.getNumberOfItems());
        order.setCompanyAddress(validateAddress(request.getCompanyAddress()).toLowerCase());
        order.setCompanyName(validateInput(request.getCompanyName().toLowerCase()));
        order.setCompanyPhoneNumber(validatePhoneNumber(String.valueOf(request.getCompanyPhoneNumber())));
        order.setOrderDescription(validateAddress(request.getOrderDescription().toLowerCase()));
        order.setCreatedAt(LocalDateTime.now());
        orderPlacementRepository.save(order);
        response.setMessage("Order Sent To Rider");
        response.setCustomerFirstName((request.getCustomerFirstName().toLowerCase()));
        response.setCustomerLastName((request.getCustomerLastName().toLowerCase()));
        response.setCustomerPhoneNumber(request.getCustomerPhoneNumber().toLowerCase());
        response.setCustomerAddress(request.getCustomerAddress().toLowerCase());
        response.setNameOfItems(request.getNameOfItems());
        response.setNumberOfItems(request.getNumberOfItems());
        response.setCompanyName(request.getCompanyName().toLowerCase());
        response.setCompanyPhoneNumber(request.getCompanyPhoneNumber());
        response.setCompanyAddress(request.getCompanyAddress().toLowerCase());
        response.setOrderDescription(request.getOrderDescription().toLowerCase());
        response.setUserId(orderId);
        return response;
    }

    public LaundererPostAdResponse laundererPostAd(LaundererPostAdRequest request) {
        Launderer launderer = laundererRepository.findByEmail(validateEmail(request.getLaundererEmailAddress().toLowerCase()));
        if (launderer.getLoggedIn()) {
            LaundererPostAdResponse response = new LaundererPostAdResponse();
            LaundryMarket market = new LaundryMarket();
            market.setCompanyName(validateInput(findByLaundererPhoneNumber(request.getCompanyName())).toLowerCase());
            market.setCompanyAddress(validateAddress(request.getCompanyAddress()).toLowerCase());
            market.setImageLink(request.getImageLink());
            market.setCreatedAt(LocalDateTime.now());
            market.setServiceDescription(request.getServiceDescription().toLowerCase());
            market.setNameOfItem(validateInput(request.getNameOfItem()).toLowerCase());
            market.setCompanyPhoneNumber(request.getCompanyPhoneNumber());
            laundererMarketRepository.save(market);
            response.setMessage("Ad posted successfully");
            response.setImageLink(market.getImageLink());
            response.setCompanyAddress(validateAddress(validateAddress(market.getCompanyAddress()).toLowerCase()));
            response.setCompanyName(validateInput(market.getCompanyName().toLowerCase()) );
            response.setCreatedAt(LocalDateTime.now());
            response.setPriceOfItem(market.getPriceOfItem());
            response.setServiceDescription(validateAddress(market.getServiceDescription()).toLowerCase());
            response.setNameOfItem(validateInput(market.getNameOfItem()).toLowerCase());
            response.setCompanyPhoneNumber(validateAddress(market.getCompanyPhoneNumber()));
            return response;
        }
        else{
            throw new LaundererNotLoggedInException("Invalid Email or Password Not Logged In");
        }
    }

//   public LaundererDeletePostResponse laundererDeletePost(VerifyEmailRequest request2, CompanyNameRequestOnly companyName){
//     LaundererDeletePostResponse response = new LaundererDeletePostResponse();
//       Launderer launderer = laundererRepository.findByEmail(request2.getEmail().toLowerCase());
//       if (launderer.getLoggedIn()) {
//           LaundryMarket market = laundererMarketRepository.findLaundryMarketByCompanyName(validateAddress(companyName.getCompanyName()).toLowerCase());
//           laundererMarketRepository.delete(market);
//       }
//       response.setMessage("Post Deleted");
//     return response;
//    }


    public LogoutLaundererResponse logoutLaunderer(LaundererLogoutRequest logoutRequest){
            Launderer launderer = laundererRepository.findByEmailAndPassword(validateEmail(logoutRequest.getEmail()).toLowerCase(), validateConfirmPassword(logoutRequest.getPassword()).toLowerCase());
            if(launderer != null){
                launderer.setLoggedIn(false);
                laundererRepository.save(launderer);
            }
            else {
                throw new IllegalArgumentException("Invalid email or password");
            }
            LogoutLaundererResponse response = new LogoutLaundererResponse();
             response.setLoggedIn(false);
             response.setMessage("logout successful");
             return response;
    }

    private void validate(SignUpLaundererRequest request) {
        if (laundererRepository.findByEmail(request.getEmail().toLowerCase()) != null) {
            throw new LaundererAlreadyExistException("Launderer with this email already exists");
        }
        if (laundererRepository.findByPhoneNumber(request.getPhoneNumber()) != null) {
            throw new LaundererAlreadyExistException("Launderer with this phone number already exists");
        }
        if (!request.getPassword().equals(request.getConfirmPassword().toLowerCase())) {
            throw new LaundererAlreadyExistException("Passwords do not match");
        }
    }

    private String verifyPhoneNumber(String phoneNumber) {
        if (laundererRepository.existsByPhoneNumber(phoneNumber)) {
            throw new LaundererAlreadyExistException("Phone number already exists");
        }
        return phoneNumber;
    }

    private String findByLaundererPhoneNumber(String phoneNumber) {
        for(Launderer launderer : laundererRepository.findAll()){
            if(launderer.getPhoneNumber().equals(phoneNumber)){
                throw new LaundererAlreadyExistException("Launderer phone number already exists");
            }
        }
        return phoneNumber;
    }

    private String validateFirstName(String firstName) {
        if (firstName.contains(" ")) {
            throw new IllegalArgumentException("Invalid first name");
        }
        return firstName;
    }

    private String validateLastName(String lastName) {
        if (lastName.contains(" ")) {
            throw new IllegalArgumentException("Invalid last name");
        }
        return lastName;
    }

    private String validateEmail(String email) {
        if (email.contains(" ") || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email;
    }

    private String validatePhoneNumber(String phoneNumber) {
        long number = Long.parseLong(phoneNumber);
        if (phoneNumber.contains(" ") || phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        return String.valueOf(number);
    }

    private String validatePassword(String password) {
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Invalid password");
        }
        return password;
    }

    private String validateInput(String input){
        if (input.contains(" ")) {
            throw new IllegalArgumentException("Cant fill in space");
        }
        return input;
    }

    private String validateAddress(String address) {
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        return address;
    }




}