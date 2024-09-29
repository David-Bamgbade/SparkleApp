package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class LaundererPostAdRequest {
    private String companyName;
    private String companyAddress;
    private long priceOfService;
    private LocalDateTime createdAt;
    private long priceOfItem;
    private String nameOfItem;
    private String serviceDescription;
    private String imageLink;
    private String companyPhoneNumber;
    private  String laundererEmailAddress;
}
