package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcceptPickupRequest {
    private Long orderId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;
    private String Esther;
    private String riderEmail;
}
