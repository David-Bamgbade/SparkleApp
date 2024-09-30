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
    private String servicePerItem;
    @Enumerated(EnumType.STRING)
    private ServiceType service;
    @Enumerated(EnumType.STRING)
    private ItemType item;
    private long orderId;

    public void setCompanyAddress(String lowerCase) {
    }

    public void setCompanyName(String lowerCase) {
    }

    public void setCompanyPhoneNumber(String s) {
    }
}