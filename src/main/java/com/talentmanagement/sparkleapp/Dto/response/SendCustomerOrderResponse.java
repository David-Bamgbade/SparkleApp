package com.talentmanagement.sparkleapp.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendCustomerOrderResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String message;
}
