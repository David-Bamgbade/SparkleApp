package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.CheckRiderAvailabilityRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignUpRiderRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateRiderRequest;
import com.talentmanagement.sparkleapp.Dto.response.CheckRiderAvailabilityResponse;
import com.talentmanagement.sparkleapp.Dto.response.SignUpRiderResponse;
import com.talentmanagement.sparkleapp.Dto.response.UpdateRiderResponse;

public interface RiderService {

    SignUpRiderResponse signUpRider(SignUpRiderRequest request);
    //LoginRiderResponse login(LoginRiderRequest request);
    CheckRiderAvailabilityResponse checkRiderAvailability(CheckRiderAvailabilityRequest request);
    //    AcceptPickupResponse pickup(AcceptPickupRequest request);
    UpdateRiderResponse update(UpdateRiderRequest request);

}
