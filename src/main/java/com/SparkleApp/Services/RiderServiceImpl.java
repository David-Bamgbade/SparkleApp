package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CheckRiderAvailabilityRequest;
import com.SparkleApp.Dto.request.SignUpRiderRequest;
import com.SparkleApp.Dto.request.UpdateRiderRequest;
import com.SparkleApp.Dto.response.CheckRiderAvailabilityResponse;
import com.SparkleApp.Dto.response.SignUpRiderResponse;
import com.SparkleApp.Dto.response.UpdateRiderResponse;
import com.SparkleApp.data.Repository.RiderRepository;
import com.SparkleApp.data.models.Rider;
import com.SparkleApp.exception.RiderAlreadyExistException;
import com.SparkleApp.exception.RiderNotFoundException;
import com.SparkleApp.exception.PasswordMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;
@Service
public class RiderServiceImpl implements RiderService{
    @Autowired
    private RiderRepository riderRepository;


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

//    @Override
//    public LoginRiderResponse login(LoginRiderRequest request) {
//        LoginRiderRequest login = new LoginRiderRequest();
//        login.setEmail(validateEmail(request.getEmail().toLowerCase()));
//        login.setPassword(validatePassword(request.getPassword().toLowerCase()));
//
//        Rider rider = riderRepository.findRiderByEmail(login.getEmail());
//        if (rider == null) {
//            throw new InvalidInputException("Invalid email or password");
//        }
//        if (!rider.getPassword().equals(login.getPassword())) {
//            throw new InvalidInputException("Invalid email or password");
//        }
//        LoginRiderResponse response = new LoginRiderResponse();
//        response.setMessage("Login Successful");
//
//        return response;
//    }

    @Override
    public CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request) {
        return null;
    }

//    @Override
//    public CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request) {
//        Rider rider = riderRepository.findRiderByEmail(validateEmail(request.getRiderEmail().toLowerCase()));
//        if (rider == null) {
//            throw new RiderNotFoundException("Rider not found");
//        }
//        if (rider.isAvailable()) {
//
//        }
//        CheckRiderAvailabilityResponse response = new CheckRiderAvailabilityResponse();
//        response.setMessage("Rider available");
//        return response;

//    }

    @Override
    public UpdateRiderResponse update(UpdateRiderRequest request) {
        Rider existingRider = riderRepository.findRiderByEmail(validateEmail(request.getEmail().toLowerCase()));
        if (existingRider == null) {
            throw new RiderNotFoundException("Rider not found");
        }
//        existingRider.setRiderStatus(valueOf(RiderStatus.valueOf(request.getStatus().toLowerCase()));
        Rider updatedRider = riderRepository.save(existingRider);
        UpdateRiderResponse response = new UpdateRiderResponse();

        response.setRiderStatus(updatedRider.getRiderStatus().toString());
        return response;
    }


    private void validate(SignUpRiderRequest request) {
        if (riderRepository.findRiderByEmail(request.getEmail()) != null) {
            throw new RiderAlreadyExistException("Rider with this email already exists");
        }
        if (riderRepository.findRiderByPhoneNumber(request.getPhoneNumber()) != null) {
            throw new RiderAlreadyExistException("Rider with this phone number already exists");

        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new PasswordMismatchException("Passwords do not match");
        }
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
