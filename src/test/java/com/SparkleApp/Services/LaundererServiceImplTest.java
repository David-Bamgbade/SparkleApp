package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.LaundererSendRequest;
import com.SparkleApp.Dto.request.LoginLaundererRequest;
import com.SparkleApp.Dto.request.SignUpLaundererRequest;
import com.SparkleApp.Dto.response.LoginLaundererResponse;
import com.SparkleApp.Dto.response.SignUpLaundererResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LaundererServiceImplTest {

    @Autowired
    private LaundererService laundererService;

    @Test
    public void testToSignUpLaunderer(){
        SignUpLaundererRequest request = new SignUpLaundererRequest();
        request.setFirstName("David");
        request.setLastName("Bamgbade");
        request.setEmail("davidsons@gmail.com");
        request.setPassword("password");
        request.setPhoneNumber("08169468242");
        request.setConfirmPassword("password");
        request.setLoggedIn(false);
        SignUpLaundererResponse response = laundererService.signUp(request);
        response.setMessage("Sign up successful");
        assertEquals(response.getMessage(), "Sign up successful");
    }

    @Test
    public void testForLaundererToSendPackage(){
        LaundererSendRequest request = new LaundererSendRequest();
        request.setCustomerFirstName("mfon");
        request.setCustomerLastName("oscer");
        request.setCustomerPhoneNumber("0908169468242");
        request.setCustomerAddress("main-street");
    }

    @Test
    public void testThatLaundererCanLogin(){
        LoginLaundererRequest request = new LoginLaundererRequest();
        request.setEmail("davidsons@gmail.com");
        request.setPassword("password");
        laundererService.loginLaunderer(request);
        LoginLaundererResponse response = laundererService.loginLaunderer(request);
        response.setLoggedIn(true);
        assertTrue(response.isLoggedIn());
    }


}