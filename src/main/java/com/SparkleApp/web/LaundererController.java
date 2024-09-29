package com.SparkleApp.web;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.Services.LaundererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/launderer")
public class LaundererController {
    @Autowired
    private LaundererService laundererService;



    @PostMapping("/signup")
    public ResponseEntity<?> signupLaunderer(@RequestBody SignUpLaundererRequest request){
        try {
            SignUpLaundererResponse response = laundererService.signUp(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginLaunderer(@RequestBody LoginLaundererRequest request){
        try {
            LoginLaundererResponse response  = laundererService.loginLaunderer(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("sendOrder")
    public ResponseEntity<?> sendCustomerOrder(@RequestBody LaundererSendRequest OrderRequest){
        try {
            LaundererSendResponse response = laundererService.laundererSendPackage(OrderRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST  );
        }
    }

    @PostMapping("/postAd")
    public ResponseEntity<?> addPostAd(  @RequestBody LaundererPostAdRequest laundererPostAdRequest,
                                         @RequestBody VerifyEmailRequest verifyEmailRequest){
        try{
            LaundererPostAdResponse response = laundererService.laundererPostAd(laundererPostAdRequest, verifyEmailRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteAd")
    public ResponseEntity<?> deleteLaundryAdPost(@RequestBody VerifyEmailRequest request1, CompanyNameRequestOnly request){
        try {
            LaundererDeletePostResponse response = laundererService.laundererDeletePost(request1, request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }








}
