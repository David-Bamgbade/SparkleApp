package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;
import com.SparkleApp.data.Repository.RiderRepository;
import com.SparkleApp.data.models.Rider;
import com.SparkleApp.data.models.RiderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RiderServiceImplTest {

    @Autowired
    private RiderServiceImpl riderServiceImpl;

    @Autowired
    RiderRepository riderRepository;

    @Test
    public void signUpRider() {
        SignUpRiderRequest signUp = new SignUpRiderRequest();
        signUp.setFirstName("John");
        signUp.setLastName("emma");
        signUp.setEmail("john@gmail.com");
        signUp.setPassword("password");
        signUp.setConfirmPassword("password");
        signUp.setAddress("Satellite town");
        signUp.setPhoneNumber("09068976669");
        SignUpRiderResponse response = new SignUpRiderResponse();
        response.setMessage("SignUp successful");
        riderServiceImpl.signUpRider(signUp);
        assertEquals(1,riderRepository.count());

    }

    @Test
    public void login() {
        LoginRiderRequest login = new LoginRiderRequest();
        login.setEmail("john@gmail.com");
        login.setPassword("password");
        riderService.login(login);
        LoginRiderResponse loginResponse = new LoginRiderResponse();
        loginResponse.setMessage("login successful");
        assertEquals(1, riderRepository.count());


    }

    @Test
    public void checkRiderAvailability() {
        CheckRiderAvailabilityRequest availability= new CheckRiderAvailabilityRequest();
        availability.setRiderEmail("john@gmail.com");
        riderService.checkRiderAvailability(availability);
        CheckRiderAvailabilityResponse response = new CheckRiderAvailabilityResponse();
        response.setMessage("Available");
        assertEquals(riderRepository.count(),1);
    }

    @Test
    public void pickup() {
        AcceptPickupRequest request = new AcceptPickupRequest();
        request.setOrderId(Long.valueOf("1"));


    }

    @Test
    public void updateRider() {
        UpdateRiderRequest request = new UpdateRiderRequest();
        request.setRiderId(1L);
        request.setRiderStatus(RiderStatus.ON_THE_WAY);
        request.setEmail("johndeo1@gmail.com");
        UpdateRiderResponse response = riderService.update(request);
        assertNotNull(response);
        assertNotNull(response.getMessage());
    }

    @Test
    public void logout() {
        LogoutRiderRequest logoutRequest = new LogoutRiderRequest();
        logoutRequest.setEmail("john@gmail.com");
        logoutRequest.setPassword("password");

        Rider rider = new Rider();
        rider.setEmail("john@gmail.com");
        rider.setPassword("password");
        riderRepository.save(rider);

        long initialCount = riderRepository.count();
        LogoutRiderResponse logoutResponse = riderServiceImpl.delete(logoutRequest);
        assertNotNull(logoutResponse);
        assertEquals("LoggedOut Successfully", logoutResponse.getMessage());
        assertEquals(initialCount - 1, riderRepository.count());
    }

}