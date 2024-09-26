package com.talentmanagement.sparkleapp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupLaundererRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
