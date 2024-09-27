package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.LaundererReceiveRequest;
import com.SparkleApp.Dto.request.LaundererSendRequest;
import com.SparkleApp.Dto.request.LoginLaundererRequest;
import com.SparkleApp.Dto.request.SignUpLaundererRequest;
import com.SparkleApp.Dto.response.LaundererReceiveResponse;
import com.SparkleApp.Dto.response.LaundererSendResponse;
import com.SparkleApp.Dto.response.LoginLaundererResponse;
import com.SparkleApp.Dto.response.SignUpLaundererResponse;

public interface LaundererService {
    SignUpLaundererResponse signUp(SignUpLaundererRequest request);
    LoginLaundererResponse loginLaunderer(LoginLaundererRequest request);
    LaundererReceiveResponse laundererReceivePackage(LaundererReceiveRequest request);
    LaundererSendResponse laundererSendPackage(LaundererSendRequest request);
}
