package com.SparkleApp.Dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginLaundererResponse {
    private String message;
    @Column(name = "is_logged_in")
    private boolean isLoggedIn;
}