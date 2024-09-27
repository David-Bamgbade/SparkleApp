package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.*;
import com.talentmanagement.sparkleapp.Dto.response.*;
import com.talentmanagement.sparkleapp.data.models.Customer;

import java.util.List;

public interface CustomerService {

    SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest);

    LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest);

    SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest);

    UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest);

    DeleteSenderOrderResponse deleteOrder(Long id );

    LogoutCustomerResponse logout(String email);

    List<Customer> allCustomer();

    List<Customer> searchCustomerByFirstName(String firstName);

    List<Customer> searchCustomerByLastName(String lastName);

}
