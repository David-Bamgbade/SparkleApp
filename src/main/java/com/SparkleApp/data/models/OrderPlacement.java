package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class OrderPlacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;
    private long totalServicePrice;
    private int NumberOfItems;
    private long pricePerService;
    private boolean paymentStatus;
    private long customerPayment;
    private String serviceDescription;
    private String nameOfItems;
    private long orderId;
    private String companyAddress;
    private String companyName;
    private String companyPhoneNumber;
    private String orderDescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}