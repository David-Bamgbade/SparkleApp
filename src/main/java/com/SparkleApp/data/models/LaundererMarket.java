package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class LaundererMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;
    private long priceForServiceOfItem;
//    @Enumerated(EnumType.STRING)
//    private ServiceType service;
//    @Enumerated(EnumType.STRING)
//    private ItemType item;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;

}
