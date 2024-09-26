package com.talentmanagement.sparkleapp.utils;

import com.talentmanagement.sparkleapp.Dto.request.SendCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignupCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.SendCustomerOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.SignUpCustomerResponse;
import com.talentmanagement.sparkleapp.Dto.response.UpdateCustomerOrderResponse;
import com.talentmanagement.sparkleapp.data.models.Customer;
import com.talentmanagement.sparkleapp.exception.InvalidEmailException;

public class Mapper {


    public static void signupCustomerMapper(SignupCustomerRequest signupCustomerRequest, Customer customer) {
        customer.setFirstName(signupCustomerRequest.getFirstName());
        customer.setLastName(signupCustomerRequest.getLastName());
        customer.setEmail(signupCustomerRequest.getEmail());
        customer.setPhoneNumber(signupCustomerRequest.getPhoneNumber());
        customer.setPassword(signupCustomerRequest.getPassword());
        customer.setConfirmPassword(signupCustomerRequest.getConfirmPassword());
        if (signupCustomerRequest.getEmail() == "@") {
            throw new InvalidEmailException("Missing @ in your email");

        }
        if (signupCustomerRequest.getEmail() == ".") {
            throw new InvalidEmailException("Missing . in your email");
        }
    }

    public static SignUpCustomerResponse signUpCustomerResponseMapper(Customer customer) {
        SignUpCustomerResponse signUpCustomerResponse = new SignUpCustomerResponse();
        signUpCustomerResponse.setCustomerId(customer.getId());
        signUpCustomerResponse.setFirstName(customer.getFirstName());
        signUpCustomerResponse.setLastName(customer.getLastName());
        signUpCustomerResponse.setEmail(customer.getEmail());
        signUpCustomerResponse.setPhoneNumber(customer.getPhoneNumber());
        signUpCustomerResponse.setPassword(customer.getPassword());
        signUpCustomerResponse.setConfirmPassword(customer.getConfirmPassword());
        signUpCustomerResponse.setMessage("Successfully signup");
        return signUpCustomerResponse;
    }

    public static void sendOrderRequestMapper(SendCustomerOrderRequest sendCustomerOrderRequest, Customer customer) {
        customer.setFirstName(sendCustomerOrderRequest.getFirstName());
        customer.setLastName(sendCustomerOrderRequest.getLastName());
        customer.setEmail(sendCustomerOrderRequest.getEmail());
        customer.setPhoneNumber(sendCustomerOrderRequest.getPhoneNumber());
        customer.setHomeAddress(sendCustomerOrderRequest.getHomeAddress());
        customer.setSpecialInstructions(sendCustomerOrderRequest.getSpecialInstructions());
        customer.setSendAt(sendCustomerOrderRequest.getSendAt());
    }

    public static SendCustomerOrderResponse getSendCustomerOrderResponse(Customer customer) {
        SendCustomerOrderResponse sendCustomerOrderResponse = new SendCustomerOrderResponse();
        sendCustomerOrderResponse.setFirstName(customer.getFirstName());
        sendCustomerOrderResponse.setLastName(customer.getLastName());
        sendCustomerOrderResponse.setEmail(customer.getEmail());
        sendCustomerOrderResponse.setPhoneNumber(customer.getPhoneNumber());
        sendCustomerOrderResponse.setHomeAddress(customer.getHomeAddress());
        sendCustomerOrderResponse.setSpecialInstruction(customer.getSpecialInstructions());
        sendCustomerOrderResponse.setMessage("Just Ordered");
        return sendCustomerOrderResponse;
    }

    public static void map(UpdateCustomerOrderRequest customerOrderRequest, Customer customer) {
        customer.setFirstName(customerOrderRequest.getFirstName());
        customer.setLastName(customerOrderRequest.getLastName());
        customer.setEmail(customerOrderRequest.getEmail());
        customer.setPhoneNumber(customerOrderRequest.getPhoneNumber());
        customer.setHomeAddress(customerOrderRequest.getHomeAddress());
        customer.setUpdatedAt(customerOrderRequest.getUpdatedAt());
    }


    public static UpdateCustomerOrderResponse Mapper(Customer customer) {
        UpdateCustomerOrderResponse customerOrderResponse = new UpdateCustomerOrderResponse();
        customerOrderResponse.setFirstName(customer.getFirstName());
        customerOrderResponse.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
        customerOrderResponse.setPhoneNumber(customer.getPhoneNumber());
        customerOrderResponse.setHomeAddress(customer.getHomeAddress());
        customerOrderResponse.setUpdatedAt(customer.getUpdatedAt());
        customerOrderResponse.setMessage("Successfully updated");
        return customerOrderResponse;
    }

}
