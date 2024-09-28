package com.SparkleApp.Services;


import com.SparkleApp.Dto.request.LoginCustomerRequest;
import com.SparkleApp.Dto.request.SendCustomerOrderRequest;
import com.SparkleApp.Dto.request.SignupCustomerRequest;
import com.SparkleApp.Dto.request.UpdateCustomerOrderRequest;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.data.Repository.CustomerRepository;
import com.SparkleApp.data.models.Customer;
import com.SparkleApp.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.SparkleApp.utils.Mapper.*;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public SignUpCustomerResponse signupCustomer(SignupCustomerRequest signupCustomerRequest) {
        validateEmail(signupCustomerRequest.getEmail());
        Customer customer = new Customer();
        signupCustomerMapper(signupCustomerRequest, customer);
        if (isValueIsNullOrEmpty(signupCustomerRequest.getFirstName()) ||
                isValueIsNullOrEmpty(signupCustomerRequest.getLastName()) ||
                isValueIsNullOrEmpty(signupCustomerRequest.getEmail()) ||
                isValueIsNullOrEmpty(signupCustomerRequest.getPhoneNumber()) ||
                isValueIsNullOrEmpty(signupCustomerRequest.getPassword())) {

            throw new EmptyFeildsException("Please enter all the fields");
        }else {
            customer.setPassword(passwordEncoder.encode(signupCustomerRequest));
            customer = customerRepository.save(customer);
            return signUpCustomerResponseMapper(customer);
        }
    }
    private void validateEmail(String email) {
        for (Customer customerEmail: customerRepository.findAll()) {
            if (customerEmail.getEmail() == email) {
                throw new EmailAlreadyExistException("Customer already exist");
            }
        }
    }
    private boolean isValueIsNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }

    @Override
    public LoginCustomerResponse loginCustomer(LoginCustomerRequest loginCustomerRequest) {
        Customer customer = findCustomerByEmail(loginCustomerRequest.getEmail());
        customer.setEmail(loginCustomerRequest.getEmail());
        customer.setPassword(loginCustomerRequest.getPassword());
//        validatePassword(customer,loginCustomerRequest.getPassword());
        customerRepository.save(customer);
        LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();
        loginCustomerResponse.setLoggedIn(true);
        loginCustomerResponse
                .setMessage("Login successfully");
        return loginCustomerResponse;
    }

    private Customer findCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email).
                orElseThrow(()-> new CustomerDoesNotExist("Customer does not exist"));
        return customer;
    }

    private void validatePassword(Customer customer, String password) {
        if (!passwordEncoder.matches(customer.getPassword(),password)){
            throw new WrongPasswordException("Wrong password or email");
        }
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
        Customer customer = findCustomerByEmail(customerOrderRequest.getEmail());
        if (isValueIsNullOrEmpty(customerOrderRequest.getFirstName())||
                isValueIsNullOrEmpty(customerOrderRequest.getLastName())||
                isValueIsNullOrEmpty(customerOrderRequest.getEmail())||
                isValueIsNullOrEmpty(customerOrderRequest.getPhoneNumber())||
                isValueIsNullOrEmpty(customerOrderRequest.getHomeAddress())||
                isValueIsNullOrEmpty(customerOrderRequest.getSpecialInstructions())){
            throw new EmptyFeildsException("Empty fields!! Please enter all the fields");
        }
        if (!(customerOrderRequest.getEmail().contains("@"))||
                !customerOrderRequest.getEmail().contains("."))throw new InvalidEmailException("Invalid email");
        map(customerOrderRequest, customer);
        customerRepository.save(customer);
        return Mapper(customer);
    }
    @Override
    public DeleteSenderOrderResponse deleteOrder(Long id) {
        Customer customer = findCustomerOrderById(id);
        customerRepository.delete(customer);
        DeleteSenderOrderResponse deleteSenderOrderResponse = new DeleteSenderOrderResponse();
        deleteSenderOrderResponse.setMessage("Order deleted successful");
        return deleteSenderOrderResponse;
    }
    private Customer findCustomerOrderById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new CustomerDoesNotExist("Can not find this customer"));
    }
}
