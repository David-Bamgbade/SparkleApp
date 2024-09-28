package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private long priceOfItem;
    private String nameOfItem;
    private String serviceDescription;
    private String imageLink;
    private LocalDateTime createdAt;
}
