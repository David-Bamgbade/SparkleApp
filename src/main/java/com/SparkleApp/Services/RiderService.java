package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;

public interface RiderService {

    SignUpRiderResponse signUpRider(SignUpRiderRequest request);
    LoginRiderResponse login(LoginRiderRequest request);
    CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request);
    AcceptPickupResponse pickup(AcceptPickupRequest request);
    UpdateRiderResponse update(UpdateRiderRequest request);
    LogoutRiderResponse delete(LogoutRiderRequest request);

}
