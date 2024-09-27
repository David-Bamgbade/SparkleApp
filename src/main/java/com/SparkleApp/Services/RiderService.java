package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CheckRiderAvailabilityRequest;
import com.SparkleApp.Dto.request.SignUpRiderRequest;
import com.SparkleApp.Dto.request.UpdateRiderRequest;
import com.SparkleApp.Dto.response.CheckRiderAvailabilityResponse;
import com.SparkleApp.Dto.response.SignUpRiderResponse;
import com.SparkleApp.Dto.response.UpdateRiderResponse;

public interface RiderService {

    SignUpRiderResponse signUpRider(SignUpRiderRequest request);
    //LoginRiderResponse login(LoginRiderRequest request);
    CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request);
    //    AcceptPickupResponse pickup(AcceptPickupRequest request);
    UpdateRiderResponse update(UpdateRiderRequest request);

}
