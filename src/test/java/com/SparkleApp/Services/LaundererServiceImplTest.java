package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LaundererServiceImplTest {

    @Autowired
    private LaundererService laundererService;

    @Test
    public void testToSignUpLaunderer(){
        SignUpLaundererRequest request = new SignUpLaundererRequest();
        request.setFirstName("Dee");
        request.setLastName("Bams");
        request.setEmail("bamss@gmail.com");
        request.setPassword("pass");
        request.setPhoneNumber("08162488242");
        request.setConfirmPassword("pass");
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
        request.setCustomerPhoneNumber("09169468242");
        request.setCustomerAddress("main-street");
        request.setNumberOfItems(3);
        request.setNameOfItems("shirt", "trauser");
        request.setOrderDescription("2 shirts and one trauser");
        request.setCompanyName("d-laundry");
        request.setCompanyPhoneNumber("09012345653");
        request.setCompanyAddress("2nd-main-street");
        LaundererSendResponse response = laundererService.laundererSendPackage(request);
        response.setMessage("order sent to rider");
        assertEquals("order sent to rider", response.getMessage());
    }

    @Test
    public void testThatLaundererCanLogin(){
        LoginLaundererRequest request = new LoginLaundererRequest();
        request.setEmail("mfon@gmail.com");
        request.setPassword("oscker");
        laundererService.loginLaunderer(request);
        LoginLaundererResponse response = laundererService.loginLaunderer(request);
        response.setLoggedIn(true);
        assertTrue(response.isLoggedIn());
    }

    @Test
    public void testThatLaundererCanReceivePackage(){
        LaundererReceiveRequest request = new LaundererReceiveRequest();
        request.setCustomerAddress("main-street");
        request.setCustomerPhoneNumber("09169468242");
        request.setCustomerFirstName("kelvin");
        request.setCustomerLastName("bams");
        request.setTotalServicePrice(200);
        request.setNumberOfItems(3);
        request.setNameOfItems("shirt, trousers, shorts");
        request.setServiceDescription("wash and iron");
        LaundererReceiveResponse response = laundererService.laundererReceivePackage(request);
        response.setMessage("received package");
        assertEquals(response.getMessage(), "received package");
    }

    @Test
    public void testThatLaundererCanPostAddOnMarketPlace(){
        LaundererPostAdRequest request = new LaundererPostAdRequest();
        VerifyEmailRequest request1 = new VerifyEmailRequest();
        request1.setEmail("mfon@gmail.com");
        request.setImageLink("llm");
        request.setCompanyAddress("3rd-street");
        request.setCompanyName("squeaky-clean");
        request.setNameOfItem("shirt");
        request.setServiceDescription("wash and iron");
        request.setPriceOfItem(200);
        request.setCompanyPhoneNumber("08123456761");
        LaundererPostAdResponse response = laundererService.laundererPostAd(request, request1);
        response.setMessage("post added");
        assertEquals(response.getMessage(), "post added");
    }




}