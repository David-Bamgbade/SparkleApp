package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private long priceForServiceOfItem;
    @Enumerated(EnumType.STRING)
    private ServiceType service;
    @Enumerated(EnumType.STRING)
    private ItemType item;
}
