package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LaundererPostAdRequest {
    private String companyName;
    private String companyAddress;
    private String item;
    private ServiceType service;
    private long priceOfService;
    private String string;
    private long priceForServiceOfItem;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long priceOfItem;
    private String nameOfItem;
    private String serviceDescription;
    private String imageLink;
    private String companyPhoneNumber;
}
