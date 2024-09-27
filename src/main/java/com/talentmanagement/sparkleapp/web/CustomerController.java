package com.talentmanagement.sparkleapp.web;

import com.talentmanagement.sparkleapp.Dto.request.LoginCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.SendCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignupCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.*;
import com.talentmanagement.sparkleapp.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    public CustomerService customerService;


    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupCustomerRequest signupCustomerRequest){
        try {
            SignUpCustomerResponse signUpCustomerResponse = customerService.signupCustomer(signupCustomerRequest);
            return new ResponseEntity<>(new CustomerApiResponse(true, signUpCustomerResponse),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("login")
    public ResponseEntity<?> loginCustomer(LoginCustomerRequest loginCustomerRequest){
        try {
            LoginCustomerResponse loginCustomerResponse = customerService.loginCustomer(loginCustomerRequest);
            return new ResponseEntity<>(new CustomerApiResponse(true, loginCustomerResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("placeOrder")
    public ResponseEntity<?> placeOrder(SendCustomerOrderRequest sendCustomerOrderRequest){
        try {
            SendCustomerOrderResponse sendCustomerOrderResponse = customerService.sendOrder(sendCustomerOrderRequest);
            return new ResponseEntity<>(new CustomerApiResponse(true, sendCustomerOrderResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(UpdateCustomerOrderRequest updateCustomerOrderRequest){
        try {
            UpdateCustomerOrderResponse updateCustomerOrderResponse = customerService.updateOrder(updateCustomerOrderRequest);
            return new ResponseEntity<>(new CustomerApiResponse(true, updateCustomerOrderResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<?> deleteOrder(Long id){
        try {
            DeleteSenderOrderResponse deleteSenderOrderResponse = customerService.deleteOrder(id);
            return new ResponseEntity<>(new CustomerApiResponse(true, deleteSenderOrderResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }

    }
}
