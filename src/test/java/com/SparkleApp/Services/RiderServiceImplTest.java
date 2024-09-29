package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CheckRiderAvailabilityRequest;
import com.SparkleApp.Dto.request.LoginRiderRequest;
import com.SparkleApp.Dto.request.SignUpRiderRequest;
import com.SparkleApp.Dto.request.UpdateRiderRequest;
import com.SparkleApp.Dto.response.CheckRiderAvailabilityResponse;
import com.SparkleApp.Dto.response.DeleteRiderResponse;
import com.SparkleApp.Dto.response.LoginRiderResponse;
import com.SparkleApp.Dto.response.SignUpRiderResponse;
import com.SparkleApp.data.Repository.RiderRepository;
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
        assertEquals(2,riderRepository.count());

    }

    @Test
    public void login() {
        LoginRiderRequest login = new LoginRiderRequest();
        login.setEmail("john@gmail.com");
        login.setPassword("password");
        riderServiceImpl.login(login);
        LoginRiderResponse loginResponse = new LoginRiderResponse();
        loginResponse.setMessage("login successful");
        assertEquals(1, riderRepository.count());
    }

    @Test
    public void checkRiderAvailability() {
        CheckRiderAvailabilityRequest availability= new CheckRiderAvailabilityRequest();
        availability.setRiderEmail("john@gmail.com");
        riderServiceImpl.checkRiderAvailability(availability);
        CheckRiderAvailabilityResponse response = new CheckRiderAvailabilityResponse();
        response.setMessage("Available");
        assertEquals(riderRepository.count(),1);
    }

    @Test
    public void pickup() {

    }

    @Test
    public void update() {
        UpdateRiderRequest update = new UpdateRiderRequest();
        update.setEmail("john@gmail.com");
        update.setRiderStatus(String.valueOf(RiderStatus.ON_THE_WAY));
        riderServiceImpl.update(update);
//        assertTrue();

    }

    @Test
    public void delete() {
        UpdateRiderRequest update = new UpdateRiderRequest();
        update.setEmail("");
        update.setRiderStatus("");
        update.setRiderStatus("");
//        riderServiceImpl.delete(update);
        DeleteRiderResponse response = new DeleteRiderResponse();
        response.setMessage("Deleted");
        assertEquals(1,riderRepository.count());
    }
}