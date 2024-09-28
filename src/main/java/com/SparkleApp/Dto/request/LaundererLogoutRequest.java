package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class LaundererLogoutRequest {
    private String email;
    private String password;
    private String loggedIn;
}
