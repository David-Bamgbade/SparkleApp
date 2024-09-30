package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.LoginCustomerRequest;
import com.SparkleApp.Dto.request.SendCustomerOrderRequest;
import com.SparkleApp.Dto.request.SignupCustomerRequest;
import com.SparkleApp.Dto.request.UpdateCustomerOrderRequest;
import com.SparkleApp.Dto.response.*;

public interface CustomerService {

    SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest);

    LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest);

    SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest);

    UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest);

    DeleteSenderOrderResponse deleteOrder(Long id );

}
