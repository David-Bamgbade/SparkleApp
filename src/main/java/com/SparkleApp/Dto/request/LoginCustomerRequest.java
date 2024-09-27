package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerRequest {
    private String email;
    private String password;
}
