package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.Payment;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaundererSendRequest {
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerAddress;
    private String companyName;
    private String companyNumber;
    private String nameOfItems;
    private long totalPrice;
    private boolean paymentStatus;
    private int numberOfItems;
    private Payment customerPayment;

}
