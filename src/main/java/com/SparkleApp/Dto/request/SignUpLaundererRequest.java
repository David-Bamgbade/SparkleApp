package com.SparkleApp.Dto.request;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime sendAt;
    private LocalDateTime receivedAt;
    private LocalDateTime createdAt;
    private long priceOfItem;
    private String nameOfItem;
    private String serviceDescription;
    private String imageLink;
}


