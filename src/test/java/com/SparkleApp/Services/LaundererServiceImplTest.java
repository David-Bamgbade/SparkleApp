package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LaundererServiceImplTest {

    @Autowired
    private LaundererService laundererService;

    @Autowired
    private CustomerService customerService;


    @Test
    public void testToSignUpLaunderer(){
        SignUpLaundererRequest request = new SignUpLaundererRequest();
        request.setFirstName("Dee");
        request.setLastName("Bamzi");
        request.setEmail("dee@gmail.com");
        request.setPassword("passd");
        request.setPhoneNumber("08168488242");
        request.setConfirmPassword("passd");
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
        request.setEmail("dee@gmail.com");
        request.setPassword("passd");
        LoginLaundererResponse response = laundererService.loginLaunderer(request);
        assertTrue(response.isLoggedIn());
    }

    @Test
    public void testThatLaundererCanLogout(){
        LaundererLogoutRequest request = new LaundererLogoutRequest();
        request.setEmail("dee@gmail.com");
        request.setPassword("passd");
        boolean response = laundererService.logoutLaunderer(request);
        assertFalse(response);
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
        request1.setEmail("dee@gmail.com");
        request.setImageLink("llm");
        request.setCompanyAddress("3rd-street");
        request.setCompanyName("clean-place");
        request.setNameOfItem("shirt");
        request.setServiceDescription("wash and iron");
        request.setPriceOfItem(200);
        request.setCompanyPhoneNumber("08123456761");
        LaundererPostAdResponse response = laundererService.laundererPostAd(request, request1);
        response.setMessage("post added");
        assertEquals(response.getMessage(), "post added");
    }

    @Test
    public void testThatLaundererCanDeletePostOnMarketplace(){
        LaundererDeleteAdRequest request = new LaundererDeleteAdRequest();
        VerifyEmailRequest request1 = new VerifyEmailRequest();
        request1.setEmail("dee@gmail.com");
        CompanyNameRequestOnly request2 = new CompanyNameRequestOnly();
        request2.setCompanyName("clean-place");
        LaundererDeletePostResponse response = laundererService.laundererDeletePost(request1, request2);
        response.setMessage("post deleted");
        assertEquals(response.getMessage(), "post deleted");
    }









}