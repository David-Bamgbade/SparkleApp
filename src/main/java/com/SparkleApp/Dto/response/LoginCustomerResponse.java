package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerResponse {
    private String message;
    private boolean isLoggedIn;
}
