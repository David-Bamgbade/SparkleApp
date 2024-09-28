package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UpdateCustomerOrderRequest {
    private Long orderId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String specialInstructions;
    private LocalDateTime updatedAt;

}
