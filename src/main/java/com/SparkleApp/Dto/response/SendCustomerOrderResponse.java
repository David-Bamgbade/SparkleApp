package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendCustomerOrderResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String specialInstruction;
    private String message;
}
