package com.SparkleApp.web;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.Services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/Rider")
public class RiderController {

    @Autowired
    private RiderService riderService;


    @PostMapping("/SignUp")
    public ResponseEntity<?> signUp(@RequestBody SignUpRiderRequest signUpRiderRequest) {
        try {
            SignUpRiderResponse result = riderService.signUpRider(signUpRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);

        }
    }

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody LoginRiderRequest loginRiderRequest) {
        try {
            LoginRiderResponse result = riderService.login(loginRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), CREATED);
        }
    }

    @PostMapping("/CheckRiderAvailability")
    public ResponseEntity<?> checkRiderAvailability(@RequestBody CheckRiderAvailabilityRequest checkRiderAvailabilityRequest) {
        try {
            CheckRiderAvailabilityResponse result = riderService.checkRiderAvailability(checkRiderAvailabilityRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/AcceptPickup")
    public ResponseEntity<?> acceptPickup(@RequestBody AcceptPickupRequest acceptPickupRequest) {
        try {
            AcceptPickupResponse result = riderService.pickup(acceptPickupRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }


    @PostMapping("/Update")
    public ResponseEntity<?> update(@RequestBody UpdateRiderRequest updateRequest) {
        try {
            UpdateRiderResponse result = riderService.update(updateRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }


    }


    @PostMapping("/Logout")
    public ResponseEntity<?> delete(@RequestBody LogoutRiderRequest logoutRiderRequest) {
        try {
            LogoutRiderResponse result = riderService.delete(logoutRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {

            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }

    }

}

