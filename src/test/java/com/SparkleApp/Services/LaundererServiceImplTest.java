package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.SignUpLaundererRequest;
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
        request.setEmail("davidson@gmail.com");
        request.setPassword("password");
        request.setPhoneNumber("08169468242");
        request.setConfirmPassword("password");
        request.setLoggedIn(false);
        SignUpLaundererResponse response = laundererService.signUp(request);
        response.setMessage("Sign up successful");
        assertEquals(response.getMessage(), "Sign up successful");
    }

}