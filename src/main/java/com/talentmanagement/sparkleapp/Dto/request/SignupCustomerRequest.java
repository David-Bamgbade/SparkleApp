package com.talentmanagement.sparkleapp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
