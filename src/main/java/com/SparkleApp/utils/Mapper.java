package com.SparkleApp.utils;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.SendCustomerOrderResponse;
import com.SparkleApp.Dto.response.SignUpCustomerResponse;
import com.SparkleApp.Dto.response.UpdateCustomerOrderResponse;
import com.SparkleApp.data.models.Customer;
import com.SparkleApp.data.models.LaundryMarket;
import com.SparkleApp.exception.InvalidEmailException;

public class Mapper {


    public static void signupCustomerMapper(SignupCustomerRequest signupCustomerRequest, Customer customer) {
        customer.setFirstName(signupCustomerRequest.getFirstName());
        customer.setLastName(signupCustomerRequest.getLastName());
        customer.setEmail(signupCustomerRequest.getEmail());
        customer.setPhoneNumber(signupCustomerRequest.getPhoneNumber());
        customer.setPassword(signupCustomerRequest.getPassword());
        if (signupCustomerRequest.getEmail().contains("@") ) {
            throw new InvalidEmailException("Missing @ in your email");

        }
        if (signupCustomerRequest.getEmail().contains(".")) {
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
        sendCustomerOrderResponse.setCustomerId(customer.getId());
        sendCustomerOrderResponse.setFirstName(customer.getFirstName());
        sendCustomerOrderResponse.setLastName(customer.getLastName());
        sendCustomerOrderResponse.setEmail(customer.getEmail());
        sendCustomerOrderResponse.setPhoneNumber(customer.getPhoneNumber());
        sendCustomerOrderResponse.setHomeAddress(customer.getHomeAddress());
        sendCustomerOrderResponse.setSpecialInstruction(customer.getSpecialInstructions());
        sendCustomerOrderResponse.setUpdatedAt(customer.getUpdatedAt());
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

    public static void postMap(CreateLaundryMarketPostRequest laundererMarketRequest, LaundryMarket laundryMarket) {
        laundryMarket.setServiceName(laundererMarketRequest.getServiceName());
        laundryMarket.setServiceDescription(laundererMarketRequest.getServiceDescription());
        laundryMarket.setPriceForServiceOfItem(laundererMarketRequest.getPriceForServiceOfItem());
        laundryMarket.setService(laundererMarketRequest.getService().WASH_AND_IRON);
        laundryMarket.setItem(laundererMarketRequest.getItem().UNDER_WEAR);
        laundryMarket.setCompanyName(laundererMarketRequest.getCompanyName());
        laundryMarket.setCompanyAddress(laundererMarketRequest.getCompanyName());
        laundryMarket.setCompanyPhoneNumber(laundererMarketRequest.getCompanyPhoneNumber());
    }

    public static CreateLaundryMarketPostResponse postMapResponse(LaundryMarket laundryMarket) {
        CreateLaundryMarketPostResponse createLaundryMarketPostResponse = new CreateLaundryMarketPostResponse();
        createLaundryMarketPostResponse.setLaundererId(laundryMarket.getId());
        createLaundryMarketPostResponse.setServiceName(laundryMarket.getServiceName());
        createLaundryMarketPostResponse.setServiceDescription(laundryMarket.getServiceDescription());
        createLaundryMarketPostResponse.setPriceForServiceOfItem(laundryMarket.getPriceForServiceOfItem());
        createLaundryMarketPostResponse.setService(laundryMarket.getService().WASH_AND_IRON);
        createLaundryMarketPostResponse.setItem(laundryMarket.getItem().UNDER_WEAR);
        createLaundryMarketPostResponse.setCompanyName(laundryMarket.getCompanyName());
        createLaundryMarketPostResponse.setCompanyPhoneNumber(laundryMarket.getCompanyPhoneNumber());
        createLaundryMarketPostResponse.setCompanyAddress(laundryMarket.getCompanyAddress());
        createLaundryMarketPostResponse.setMessage("Posted successfully");
        return createLaundryMarketPostResponse;
    }

    private static void postRequestMapper(UpdateLaundryMarketPostRequest laundererMarketPostRequest, LaundryMarket laundryMarket) {
        laundryMarket.setServiceName(laundererMarketPostRequest.getServiceName());
        laundryMarket.setServiceDescription(laundryMarket.getServiceDescription());
        laundryMarket.setPriceForServiceOfItem(laundryMarket.getPriceForServiceOfItem());
        laundryMarket.setService(laundererMarketPostRequest.getService().WASH_AND_IRON);
        laundryMarket.setItem(laundererMarketPostRequest.getItem().HOODIE);
        laundryMarket.setCompanyName(laundryMarket.getCompanyName());
        laundryMarket.setCompanyAddress(laundererMarketPostRequest.getCompanyAddress());
        laundryMarket.setCompanyPhoneNumber(laundererMarketPostRequest.getCompanyPhoneNumber());
    }

    private static LaundryMarket getLaundryMarket(UpdateLaundryMarketPostRequest laundererMarketPostRequest) {
        LaundryMarket laundryMarket = new LaundryMarket();
        laundryMarket.setServiceName(laundererMarketPostRequest.getServiceName());
        laundryMarket.setServiceDescription(laundryMarket.getServiceDescription());
        laundryMarket.setPriceForServiceOfItem(laundryMarket.getPriceForServiceOfItem());
        laundryMarket.setService(laundererMarketPostRequest.getService().WASH_AND_IRON);
        laundryMarket.setItem(laundererMarketPostRequest.getItem().HOODIE);
        laundryMarket.setCompanyName(laundryMarket.getCompanyName());
        laundryMarket.setCompanyAddress(laundererMarketPostRequest.getCompanyAddress());
        laundryMarket.setCompanyPhoneNumber(laundererMarketPostRequest.getCompanyPhoneNumber());
        return laundryMarket;
    }


}
