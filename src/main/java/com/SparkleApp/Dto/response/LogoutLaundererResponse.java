package com.SparkleApp.Dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutLaundererResponse {
    @Column(name = "is_logged_in")
    private boolean loggedIn;
    private String message;
}
