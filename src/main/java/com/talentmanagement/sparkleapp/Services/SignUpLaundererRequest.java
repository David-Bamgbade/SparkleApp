package com.talentmanagement.sparkleapp.Services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpLaundererRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
