package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.*;
import com.SparkleApp.Dto.response.*;

public interface LaundererService {
    SignUpLaundererResponse signUp(SignUpLaundererRequest request);
    LoginLaundererResponse loginLaunderer(LoginLaundererRequest request);
    LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request);
    LaundererSendResponse laundererSendPackage(LaundererSendRequest request);
    LaundererDeletePostResponse laundererDeletePost(VerifyEmailRequest request2, CompanyNameRequestOnly companyName);
    boolean logoutLaunderer(LaundererLogoutRequest request);
    LaundererPostAdResponse laundererPostAd(LaundererPostAdRequest request, VerifyEmailRequest request1);
}
