package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.data.Repository.LaundererRepository;
import com.SparkleApp.data.Repository.OrderPlacementRepository;
import com.SparkleApp.data.Repository.RiderRepository;
import com.SparkleApp.data.models.OrderPlacement;
import com.SparkleApp.data.models.OrderStatus;
import com.SparkleApp.data.models.Rider;
import com.SparkleApp.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import static java.lang.String.valueOf;
@Service
public class RiderServiceImpl implements RiderService{
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private OrderPlacementRepository orderPlacementRepository;


    @Override
    public SignUpRiderResponse signUpRider(SignUpRiderRequest request) {
        validate(request);
        Rider rider = new Rider();
        rider.setFirstName(validateFirstName(request.getFirstName().toLowerCase()));
        rider.setLastName(validateLastName(request.getLastName().toLowerCase()));
        rider.setEmail(validateEmail(request.getEmail().toLowerCase()));
        rider.setPhoneNumber(validatePhoneNumber(request.getPhoneNumber().toLowerCase()));
        rider.setPassword(validatePassword(request.getPassword().toLowerCase()));
        rider.setConfirmPassword(validatePassword(request.getConfirmPassword().toLowerCase()));
        riderRepository.save(rider);
        SignUpRiderResponse response = new SignUpRiderResponse();
        response.setMessage("Registration Successful");

        return response;
    }


    @Override
    public LoginRiderResponse login(LoginRiderRequest request) {
        LoginRiderRequest login = new LoginRiderRequest();
        login.setEmail(validateEmail(request.getEmail().toLowerCase()));
        login.setPassword(validatePassword(request.getPassword().toLowerCase()));

        Rider rider = riderRepository.findRiderByEmail(login.getEmail());
        if (rider == null) {
            throw new InvalidInputException("Invalid email or password");
        }
        if (!rider.getPassword().equals(login.getPassword())) {
            throw new InvalidInputException("Invalid email or password");
        }
        LoginRiderResponse response = new LoginRiderResponse();
        response.setMessage("Login Successful");

        return response;
    }

    @Override
    public CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request) {
        Rider rider = riderRepository.findRiderByEmail(validateEmail(request.getRiderEmail().toLowerCase()));
       if (rider == null) {
            throw new RiderNotFoundException("Rider not found");
       }
       if (rider.isAvailable()) {
           throw new RiderNotAvailableException("Rider is not available");
       }
        CheckRiderAvailabilityResponse response = new CheckRiderAvailabilityResponse();
        response.setMessage("Rider available");
        return response;
    }

    @Override
    public AcceptPickupResponse pickup(AcceptPickupRequest request) {
         OrderPlacement orderPlacement = orderPlacementRepository.findByOrderId(request.getOrderId());
         if (orderPlacement == null) {
             throw new OrderNotFoundException("Order not found");
         }
         orderPlacement.setOrderStatus(OrderStatus.ACCEPTED);
         orderPlacementRepository.save(orderPlacement);
         AcceptPickupResponse response = new AcceptPickupResponse();
         response.setMessage("Pickup successful");
        return response;


    }


    @Override
    public UpdateRiderResponse update(UpdateRiderRequest request) {
        Rider existingRider = riderRepository.findRiderByEmail(validateEmail(request.getEmail().toLowerCase()));
            if (existingRider != null) {
                existingRider.setId(request.getRiderId());
                existingRider.setRiderStatus(request.getRiderStatus());
                existingRider.setEmail(request.getEmail());
                riderRepository.save(existingRider);
            }
            UpdateRiderResponse response = new UpdateRiderResponse();
            response.setMessage("rider updated successfully");
            return response;

    }



    @Override
    public LogoutRiderResponse delete(LogoutRiderRequest request) {
        riderRepository.findRiderByEmail(validateEmail(request.getEmail().toLowerCase()));
        String password = request.getPassword();
        boolean isAmong = ifAmong(password);
        if (isAmong) {
            throw new RuntimeException("Username doesn't match");
        }
        LogoutRiderResponse response = new LogoutRiderResponse();
        response.setMessage("Logout Successful");
        return response;

    }

private boolean ifAmong(String password) {
    List<Rider> riders = riderRepository.findAll();
    for (Rider rider : riders) {
        if (rider.getPassword().equals(password)) {
            return true;
        }
    }
    return false;

}


private void validate(SignUpRiderRequest request) {
        if (riderRepository.findRiderByEmail(request.getEmail()) != null) {
            throw new RiderAlreadyExistException("Rider with this email already exists");
        }
        if (riderRepository.findRiderByPhoneNumber(request.getPhoneNumber()) != null) {
           throw new RiderAlreadyExistException("Rider with this phone number already exists");

       }
//        if (!request.getPassword().equals(request.getConfirmPassword())) {
//            throw new PasswordMismatchException("Passwords do not match");
//        }
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
        return valueOf(number);
    }

    private String validatePassword(String password) {
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Invalid password");
        }
        return password;
    }
}
