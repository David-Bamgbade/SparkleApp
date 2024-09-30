package com.SparkleApp.Dto.response;

import com.SparkleApp.data.models.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class LaundererPostAdResponse {
    private String message;
    private String imageLink;
    private String companyName;
    private String companyAddress;
    private ServiceType service;
    private long priceOfService;
    private LocalDateTime createdAt;
    private long priceOfItem;
    private String nameOfItem;
    private String serviceDescription;
    private String companyPhoneNumber;
}
