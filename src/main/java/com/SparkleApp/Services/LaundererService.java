package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;

public interface LaundererService {
    SignUpLaundererResponse signUp(SignUpLaundererRequest request);
    LoginLaundererResponse loginLaunderer(LoginLaundererRequest request);
    LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request);
//    LaundererPostAdResponse laundererPostAd(LaundererPostAdRequest request, VerifyEmailRequest request2);
    LaundererSendResponse laundererSendPackage(LaundererSendRequest request);
}
