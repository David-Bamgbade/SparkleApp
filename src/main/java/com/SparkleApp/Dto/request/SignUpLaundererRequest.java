package com.SparkleApp.Dto.request;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SignUpLaundererRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private boolean loggedIn;
}


