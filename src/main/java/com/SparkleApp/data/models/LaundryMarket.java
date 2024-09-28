package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class LaundryMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private String serviceDescription;
    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;

    private long priceOfItem;
    private String nameOfItem;
    private String imageLink;
    private LocalDateTime createdAt;

    private long priceForServiceOfItem;
    @Enumerated(EnumType.STRING)
    private ServiceType service;
    private ItemType item;
}
