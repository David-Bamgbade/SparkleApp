package com.SparkleApp.Dto.response;

import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.ServiceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLaundryMarketPostResponse {
    private String serviceName;
    private String serviceDescription;
    private String companyName;
    private String companyPhoneNumber;
    private long priceForServiceOfItem;
    @Enumerated(EnumType.STRING)
    private ServiceType service;
    @Enumerated(EnumType.STRING)
    private ItemType item;
}
