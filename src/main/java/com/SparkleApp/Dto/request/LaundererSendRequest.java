package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LaundererSendRequest {
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

    public String[] setNameOfItems(String... items) {
        return items;
    }
}
