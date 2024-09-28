package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaundererReceiveRequest {
    private String customerFirstName;
    private String  customerLastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;
    private long totalServicePrice;
    private int NumberOfItems;
    private long pricePerService;
    private boolean paymentStatus;
    private String serviceDescription;
    private String nameOfItems;
}
