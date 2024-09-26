package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.*;
import com.talentmanagement.sparkleapp.Dto.response.*;

public interface CustomerService {

    SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest);

    LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest);

    SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest);

    UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest);

    DeleteSenderOrderResponse deleteOrder(Long id );

}
