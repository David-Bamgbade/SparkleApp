package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.LoginCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.SendCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignupCustomerRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateCustomerOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.LoginCustomerResponse;
import com.talentmanagement.sparkleapp.Dto.response.SendCustomerOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.SignUpCustomerResponse;
import com.talentmanagement.sparkleapp.data.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void testThatCustomerCanSignup(){
        createdCustomerSignup();
        SignUpCustomerResponse signUpCustomerResponse = customerService.signupCustomer(createdCustomerSignup());
        assertThat(signUpCustomerResponse).isNotNull();
        assertThat(signUpCustomerResponse.getMessage()).contains("Successfully signup");
    }

    private static SignupCustomerRequest createdCustomerSignup() {
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("Christian");
        signupCustomerRequest.setLastName("Lucky");
        signupCustomerRequest.setEmail("christian@gmail.com");
        signupCustomerRequest.setPhoneNumber("09012457786");
        signupCustomerRequest.setPassword("1234");
        signupCustomerRequest.setConfirmPassword("1234");
        return signupCustomerRequest;
    }

    @Test
    public void testThatCustomerCanLogin(){
        createdCustomerSignup();
        LoginCustomerRequest loginCustomerRequest = new LoginCustomerRequest();
        loginCustomerRequest.setEmail("mfon@gmail.com");
        loginCustomerRequest.setEmail("1234");
        LoginCustomerResponse loginCustomerResponse = customerService.loginCustomer(loginCustomerRequest);
        assertThat(loginCustomerResponse).isNotNull();
        assertThat(loginCustomerResponse.getMessage()).contains("Login successfully");

    }

    @Test
    public void testThatCustomerCanSendOrder() {
        SendCustomerOrderRequest sendCustomerOrderRequest = new SendCustomerOrderRequest();
        sendCustomerOrder(sendCustomerOrderRequest);
        SendCustomerOrderResponse sendCustomerOrderResponse = customerService.sendOrder(sendCustomerOrderRequest);
        assertThat(sendCustomerOrderResponse).isNotNull();
        assertThat(sendCustomerOrderResponse.getMessage()).contains("Just Ordered");
    }

    private static void sendCustomerOrder(SendCustomerOrderRequest sendCustomerOrderRequest) {
        sendCustomerOrderRequest.setFirstName("Wale");
        sendCustomerOrderRequest.setLastName("Timi");
        sendCustomerOrderRequest.setEmail("wale@gmail.com");
        sendCustomerOrderRequest.setPhoneNumber("08023453213");
        sendCustomerOrderRequest.setHomeAddress("230 herbert macaulay way, sabo yaba Lagos");
        sendCustomerOrderRequest.setSpecialInstructions("Wash and fold, don't use detergent on the shirt");
        sendCustomerOrderRequest.setSendAt(LocalDateTime.now());
    }

    @Test
    public void testThatCustomerUpdateOrder(){
        UpdateCustomerOrderRequest updateCustomerOrderRequest = new UpdateCustomerOrderRequest();

    }
}