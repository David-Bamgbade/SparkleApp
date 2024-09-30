package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UpdateCustomerOrderResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String specialInstructions;
    private LocalDateTime updatedAt;
    private String message;
}
