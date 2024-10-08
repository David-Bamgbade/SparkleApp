package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.LoginCustomerRequest;
import com.SparkleApp.Dto.request.SendCustomerOrderRequest;
import com.SparkleApp.Dto.request.SignupCustomerRequest;
import com.SparkleApp.Dto.request.UpdateCustomerOrderRequest;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.data.Repository.CustomerRepository;
import com.SparkleApp.exception.EmailAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("Christian");
        signupCustomerRequest.setLastName("Lucky");
        signupCustomerRequest.setEmail("christian@gmail.com");
        signupCustomerRequest.setPhoneNumber("09012457786");
        signupCustomerRequest.setPassword("1234");
        SignUpCustomerResponse signUpCustomerResponse = customerService.signupCustomer(signupCustomerRequest);
        assertThat(signUpCustomerResponse).isNotNull();
        assertThat(signUpCustomerResponse.getMessage()).contains("Successfully signup");
    }

    @Test
    public void testThatTwoUsersCanNotSignupWithTheSameEmail(){
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("Christian");
        signupCustomerRequest.setLastName("Lucky");
        signupCustomerRequest.setEmail("christian@gmail.com");
        signupCustomerRequest.setPhoneNumber("09012457786");
        signupCustomerRequest.setPassword("1234");
        assertThrows(EmailAlreadyExistException.class,()->{

        });

    }

    @Test
    public void testThatCustomerCanLogin(){
        SignupCustomerRequest signupCustomerRequest = new SignupCustomerRequest();
        signupCustomerRequest.setFirstName("Christian");
        signupCustomerRequest.setLastName("Lucky");
        signupCustomerRequest.setEmail("christian@gmail.com");
        signupCustomerRequest.setPhoneNumber("09012457786");
        signupCustomerRequest.setPassword("1234");
        SignUpCustomerResponse signUpCustomerResponse = customerService.signupCustomer(signupCustomerRequest);
        assertThat(signUpCustomerResponse).isNotNull();
        assertThat(signUpCustomerResponse.getMessage()).contains("Successfully signup");
        LoginCustomerRequest loginCustomerRequest = new LoginCustomerRequest();
        loginCustomerRequest.setPassword("1234");
        loginCustomerRequest.setEmail("christian@gmail.com");
        LoginCustomerResponse loginCustomerResponse = customerService.loginCustomer(loginCustomerRequest);
        assertThat(loginCustomerResponse).isNotNull();
        assertThat(loginCustomerResponse.getMessage()).contains("Login successfully");
    }

    @Test
    public void testThatCustomerCanSendOrder() {
        SendCustomerOrderRequest sendCustomerOrderRequest = new SendCustomerOrderRequest();
        sendCustomerOrderRequest.setFirstName("Wale");
        sendCustomerOrderRequest.setLastName("Timi");
        sendCustomerOrderRequest.setEmail("wale@gmail.com");
        sendCustomerOrderRequest.setPhoneNumber("08023453213");
        sendCustomerOrderRequest.setHomeAddress("230 herbert macaulay way, sabo yaba Lagos");
        sendCustomerOrderRequest.setSpecialInstructions("Wash and fold, don't use detergent on the shirt");
        sendCustomerOrderRequest.setSendAt(LocalDateTime.now());
        SendCustomerOrderResponse sendCustomerOrderResponse = customerService.sendOrder(sendCustomerOrderRequest);
        assertThat(sendCustomerOrderResponse).isNotNull();
        assertThat(sendCustomerOrderResponse.getMessage()).contains("Just Ordered");
    }

    @Test
    public void testThatCustomerUpdateOrder(){
        SendCustomerOrderRequest sendCustomerOrderRequest = new SendCustomerOrderRequest();
        sendCustomerOrderRequest.setFirstName("Wale");
        sendCustomerOrderRequest.setLastName("Timi");
        sendCustomerOrderRequest.setEmail("wale@gmail.com");
        sendCustomerOrderRequest.setPhoneNumber("08023453213");
        sendCustomerOrderRequest.setHomeAddress("230 herbert macaulay way, sabo yaba Lagos");
        sendCustomerOrderRequest.setSpecialInstructions("Wash and fold, don't use detergent on the shirt");
        sendCustomerOrderRequest.setSendAt(LocalDateTime.now());
        SendCustomerOrderResponse sendCustomerOrderResponse = customerService.sendOrder(sendCustomerOrderRequest);
        assertThat(sendCustomerOrderResponse).isNotNull();
        assertThat(sendCustomerOrderResponse.getMessage()).contains("Just Ordered");
        UpdateCustomerOrderRequest updateCustomerOrderRequest = new UpdateCustomerOrderRequest();
        updateCustomerOrderRequest.setFirstName("Dayo");
        updateCustomerOrderRequest.setLastName("Chinnedu");
        updateCustomerOrderRequest.setEmail("wale@gmail.com");
        updateCustomerOrderRequest.setPhoneNumber("0901245432");
        updateCustomerOrderRequest.setHomeAddress("sabo, yaba");
        updateCustomerOrderRequest.setSpecialInstructions("dont use detergent");
        UpdateCustomerOrderResponse updateCustomerOrderResponse = customerService.updateOrder(updateCustomerOrderRequest);
        assertThat(updateCustomerOrderResponse.getMessage()).contains("Successfully updated");
    }
    @Test
    public void testThatCustomerCanDeleteOrders(){
        SendCustomerOrderRequest sendCustomerOrderRequest = new SendCustomerOrderRequest();
        sendCustomerOrderRequest.setFirstName("Wale");
        sendCustomerOrderRequest.setLastName("Timi");
        sendCustomerOrderRequest.setEmail("wale@gmail.com");
        sendCustomerOrderRequest.setPhoneNumber("08023453213");
        sendCustomerOrderRequest.setHomeAddress("230 herbert macaulay way, sabo yaba Lagos");
        sendCustomerOrderRequest.setSpecialInstructions("Wash and fold, don't use detergent on the shirt");
        sendCustomerOrderRequest.setSendAt(LocalDateTime.now());
        SendCustomerOrderResponse sendCustomerOrderResponse = customerService.sendOrder(sendCustomerOrderRequest);
        assertThat(sendCustomerOrderResponse.getMessage()).contains("Just Ordered");
        Long id = sendCustomerOrderResponse.getCustomerId();
        DeleteSenderOrderResponse deleteSenderOrderResponse = customerService.deleteOrder(id);
        assertThat(deleteSenderOrderResponse.getMessage()).contains("Order deleted successful");

    }

}