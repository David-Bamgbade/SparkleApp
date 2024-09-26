package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.LaundererReceiveRequest;
import com.talentmanagement.sparkleapp.Dto.request.LaundererSendRequest;
import com.talentmanagement.sparkleapp.Dto.request.LoginLaundererRequest;
import com.talentmanagement.sparkleapp.Dto.request.SignupLaundererRequest;
import com.talentmanagement.sparkleapp.Dto.response.LaundererReceiveResponse;
import com.talentmanagement.sparkleapp.Dto.response.LaundererSendResponse;
import com.talentmanagement.sparkleapp.Dto.response.LoginLaundererResponse;
import com.talentmanagement.sparkleapp.Dto.response.SignUpLaundererResponse;

public interface LaundererService {
    SignUpLaundererResponse signUp(SignupLaundererRequest request);
    LoginLaundererResponse loginLaunderer(LoginLaundererRequest request);
    LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request);
    LaundererSendResponse laundererSendPackage(LaundererSendRequest request);
}
