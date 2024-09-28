package com.SparkleApp.controllers;

import com.SparkleApp.Dto.request.DeleteRiderRequest;
import com.SparkleApp.Dto.request.LoginRiderRequest;
import com.SparkleApp.Dto.request.SignUpRiderRequest;
import com.SparkleApp.Dto.request.UpdateRiderRequest;
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

    @PostMapping("/Update")
    public ResponseEntity<?> update(@RequestBody UpdateRiderRequest updateRequest) {
        try {
            UpdateRiderResponse result = riderService.update(updateRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }


    }


    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteRiderRequest deleteRiderRequest) {
        try {
            DeleteRiderResponse result = riderService.delete(deleteRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception exception) {

            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }

}

