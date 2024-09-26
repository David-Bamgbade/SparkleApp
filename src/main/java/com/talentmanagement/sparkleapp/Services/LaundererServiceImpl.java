package com.talentmanagement.sparkleapp.Services;


import com.talentmanagement.sparkleapp.Dto.request.*;
import com.talentmanagement.sparkleapp.Dto.response.*;
import com.talentmanagement.sparkleapp.data.Repository.OrderPlacementRepository;
import com.talentmanagement.sparkleapp.data.models.ItemType;
import com.talentmanagement.sparkleapp.data.models.OrderPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundererServiceImpl implements LaundererService{


    @Autowired
    private OrderPlacementRepository orderPlacementRepository;

    @Override
    public SignUpLaundererResponse signUp(SignupLaundererRequest request) {
        return null;
    }

    @Override
    public LoginLaundererResponse loginLaunderer(LoginLaundererRequest request) {
        return null;
    }

    @Override
    public LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request) {
        return null;
    }

    @Override
    public LaundererSendResponse laundererSendPackage(LaundererSendRequest request) {
        LaundererSendResponse response = new LaundererSendResponse();
        OrderPlacement order = new OrderPlacement();
        order.setId(order.getId());
        order.setCustomerFirstName(validateFirstName(request.getCustomerFirstName()).toLowerCase());
        order.setCustomerLastName(validateLastName(request.getCustomerLastName()).toLowerCase());
        order.setCustomerPhoneNumber(validatePhoneNumber(request.getCustomerPhoneNumber()).toLowerCase());
        order.setCustomerAddress(validateAddress(request.getCustomerAddress()).toLowerCase());
        order.setTotalServicePrice(request.getTotalPrice());
        order.setPaymentStatus(request.isPaymentStatus());
        order.setNumberOfItems(request.getNumberOfItems());
        orderPlacementRepository.save(order);
        response.setMessage("Order Sent To Rider");
        return response;
    }

    public LaundererPostAdResponse laundererPostAd(LaundererPostAdRequest request) {


        return null;
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