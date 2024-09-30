package com.SparkleApp.web;


import com.SparkleApp.Dto.request.LoginCustomerRequest;
import com.SparkleApp.Dto.request.SendCustomerOrderRequest;
import com.SparkleApp.Dto.request.SignupCustomerRequest;
import com.SparkleApp.Dto.request.UpdateCustomerOrderRequest;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.Services.CustomerService;
import com.SparkleApp.Services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

<<<<<<< HEAD
    private final CustomerService customerService;
    private final EmailService emailService;
=======
    public final CustomerService customerService;
>>>>>>> 208bc202dc8ce3e7a19cd3b92f361f0037215e57


    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupCustomerRequest signupCustomerRequest){
        try {
            SignUpCustomerResponse signUpCustomerResponse =  customerService.signupCustomer(signupCustomerRequest);

            emailService.sendEmail(signupCustomerRequest.getEmail(),
                    "Welcome to Sparkle Marketplace ",
                    STR."Hello \{signupCustomerRequest.getFirstName()}\n Welcome to sparkle Marketplace! We're thrilled to have you on board.\n Thank you for choosing us for your laundry needs. We are committed to providing you with the best service possible.");

            return new ResponseEntity<>(new CustomerApiResponse(true, signUpCustomerResponse),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new CustomerApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginCustomerRequest loginCustomerRequest){
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

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody SendCustomerOrderRequest sendCustomerOrderRequest){
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
    public ResponseEntity<?> updateOrder(@RequestBody UpdateCustomerOrderRequest updateCustomerOrderRequest){
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
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
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
