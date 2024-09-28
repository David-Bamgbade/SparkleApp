package com.SparkleApp.Dto.response;

import com.SparkleApp.data.models.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LaundererSendResponse {
    private String message;
    private long userId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerAddress;
    private String companyName;
    private String companyPhoneNumber;
    private String[] nameOfItems;
    private long totalPrice;
    private boolean paymentStatus;
    private int numberOfItems;
    private Payment customerPayment;
    private String orderDescription;
    private String companyAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

