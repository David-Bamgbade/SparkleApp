package com.SparkleApp.Dto.response;

import com.SparkleApp.data.models.Payment;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LaundererReceiveResponse {
     private long laundererReceiveId;
     private String customerFirstName;
     private String customerLastName;
     private String customerEmail;
     private String customerPhoneNumber;
     private String customerAddress;
     private int numberOfItems;
     private String nameOfItems;
     private Payment customerPayment;
     private String message;
}
