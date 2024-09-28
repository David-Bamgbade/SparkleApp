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
        if(laundererRepository.findByEmailAndPhoneNumber(validateEmail(request.getEmail().toLowerCase()), validatePhoneNumber(request.getPhoneNumber())) == null){
            Launderer launderer = new Launderer();
            launderer.setFirstName(validateFirstName(request.getFirstName()).toLowerCase());
            launderer.setLastName(validateLastName(request.getLastName()).toLowerCase());
            launderer.setPhoneNumber(validatePhoneNumber(verifyPhoneNumber(request.getPhoneNumber())));
            launderer.setLoggedIn(false);
            launderer.setEmail(validateEmail(request.getEmail()).toLowerCase());
            launderer.setPassword(validatePassword(request.getPassword()).toLowerCase());
            launderer.setConfirmPassword(validatePassword(request.getConfirmPassword()).toLowerCase());
            laundererRepository.save(launderer);
        }
        else{
            throw new IllegalArgumentException("User already exists");
        }
        response.setMessage("Successfully signed up");
        return response;
    }


    @Override
    public LoginLaundererResponse loginLaunderer(LoginLaundererRequest request) {
        LoginLaundererResponse response = new LoginLaundererResponse();
        Launderer launderer = laundererRepository.findByEmailAndPassword(
                validateEmail(request.getEmail()).toLowerCase(),
                validatePassword(request.getPassword()).toLowerCase()
        );
        if (launderer != null) {
            response.setLoggedIn(true);
            launderer.setLoggedIn(true);
        } else {
            response.setLoggedIn(false);
            throw new RuntimeException("Invalid Email or Password");
        }
        return response;
    }

    @Override
    public LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request) {
        LaundererReceiveResponse response = new LaundererReceiveResponse();
        OrderPlacement order = new OrderPlacement();
        order.setCustomerFirstName(validateFirstName(request.getFirstName()).toLowerCase());
        order.setCustomerLastName(validateLastName(request.getLastName()).toLowerCase());
        order.setNumberOfItems(request.getNumberOfItems());
        order.setCustomerPhoneNumber(request.getCustomerPhoneNumber());
        order.setCustomerAddress(request.getCustomerAddress().toLowerCase());
        order.setService(request.getService());
        order.setItem(request.getItem());
        orderPlacementRepository.save(order);
        response.setCustomerFirstName(response.getCustomerFirstName().toLowerCase());
        response.setCustomerLastName(response.getCustomerLastName().toLowerCase());
        response.setCustomerPhoneNumber(response.getCustomerPhoneNumber().toLowerCase());
        response.setCustomerAddress(response.getCustomerAddress().toLowerCase());
        response.setNameOfItems(response.getNameOfItems().toLowerCase());
        response.setNumberOfItems(response.getNumberOfItems().toLowerCase());
        return response;
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
        order.setCompanyAddress(validateAddress(request.getCustomerAddress()).toLowerCase());
        order.setCompanyName(validateInput(request.getCompanyName().toLowerCase()));
        order.setCompanyPhoneNumber(validatePhoneNumber(request.getCustomerPhoneNumber()));
        orderPlacementRepository.save(order);
        response.setMessage("Order Sent To Rider");
        response.setUserId(orderId);
        return response;
    }

    public LaundererPostAdResponse laundererPostAd(LaundererPostAdRequest request) {
        SignUpLaundererRequest request1 = new SignUpLaundererRequest();
        Launderer launderer = laundererRepository.findByEmail(request1.getEmail().toLowerCase());
        if (launderer.isLoggedIn()) {
            LaundererPostAdResponse response = new LaundererPostAdResponse();
            LaundryMarket market = new LaundryMarket();
            market.setCompanyName(validateInput(findByLaundererPhoneNumber(request.getCompanyName())).toLowerCase());
            market.setPriceForServiceOfItem(request.getPriceForServiceOfItem());
            market.setCompanyAddress(validateAddress(request.getCompanyAddress()).toLowerCase());
            laundererMarketRepository.save(market);
            response.setMessage("Ad posted successfully");
            return response;
        }
        else{
            throw new LaundererNotLoggedInException("Invalid Email or Password Not Logged In");
        }
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