package com.talentmanagement.sparkleapp.data.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String homeAddress;
    private String specialInstructions;
    private boolean isLoggedIn;
    private LocalDateTime sendAt;
    private LocalDateTime updatedAt;
}
