package com.talentmanagement.sparkleapp.Services;


import com.talentmanagement.sparkleapp.Dto.request.LoginCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.SendCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignupCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.*;
import com.talentmanagement.sparkleapp.data.Repository.CustomerRepository;
import com.talentmanagement.sparkleapp.data.models.Customer;
import com.talentmanagement.sparkleapp.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.talentmanagement.sparkleapp.utils.Mapper.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest) {
        Customer customer = new Customer();
        signupCustomerMapper(signupCustomerRequest, customer);
        if (isValueIsNullOrEmpty(signupCustomerRequest.getFirstName())||
                isValueIsNullOrEmpty(signupCustomerRequest.getLastName())||
                isValueIsNullOrEmpty(signupCustomerRequest.getEmail())||
                isValueIsNullOrEmpty(signupCustomerRequest.getPhoneNumber())||
                isValueIsNullOrEmpty(signupCustomerRequest.getPassword())||
                isValueIsNullOrEmpty(signupCustomerRequest.getConfirmPassword())){
            throw new EmptyFeildsException("Please enter all the fields");
        }
        if (!(customer.getConfirmPassword() == customer.getPassword())){
            throw new UnMatchablePasswordException("Password mismatch");
        }
        customer.setPassword(passwordEncoder.encode((CharSequence) signupCustomerRequest));
        customer = customerRepository.save(customer);
        return signUpCustomerResponseMapper(customer);
    }


    private boolean isValueIsNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }

    @Override
    public LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest) {
        Customer customer = findCustomerByEmail(loginCustomerRequest.getEmail());
        customer.setPassword(loginCustomerRequest.getPassword());
        validatePassword(customer, loginCustomerRequest.getPassword());
        customerRepository.save(customer);
        LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();
        loginCustomerResponse.setLoggedIn(true);
        loginCustomerResponse.setMessage("Login successfully");
        return loginCustomerResponse;
    }

    private void validatePassword(Customer customer, String password) {
        if (!passwordEncoder.matches(customer.getPassword(), password)){
            throw new WrongPasswordException("Wrong password or email");
        }
    }

    private Customer findCustomerByEmail(String email) {
        return customerRepository.existByEmail(email)
                .orElseThrow(()-> new CustomerDoesNotExist("Customer does not exist"));
    }

    @Override
    public SendCustomerOrderResponse sendOrder(SendCustomerOrderRequest sendCustomerOrderRequest) {
        Customer customer = new Customer();
        if (isValueIsNullOrEmpty(sendCustomerOrderRequest.getFirstName())||
                isValueIsNullOrEmpty(sendCustomerOrderRequest.getLastName())||
                isValueIsNullOrEmpty(sendCustomerOrderRequest.getEmail())||
                isValueIsNullOrEmpty(sendCustomerOrderRequest.getPhoneNumber())||
                isValueIsNullOrEmpty(sendCustomerOrderRequest.getHomeAddress())||
                isValueIsNullOrEmpty(sendCustomerOrderRequest.getSpecialInstructions())){
            throw new EmptyFeildsException("Please fill all the fields");
        }
        if (!(sendCustomerOrderRequest.getEmail().contains("@")||
                sendCustomerOrderRequest.getEmail().contains("."))){
            throw new InvalidEmailException("Invalid email or password");
        }
        sendOrderRequestMapper(sendCustomerOrderRequest, customer);
        customerRepository.save(customer);
        return getSendCustomerOrderResponse(customer);
    }

    @Override
    public UpdateCustomerOrderResponse updateOrder(UpdateCustomerOrderRequest customerOrderRequest) {
        return null;
    }

    @Override
    public DeleteSenderOrderResponse deleteOrder(Long id) {
        return null;
    }
}
