package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LaundererPostAdRequest {
    private String companyName;
    private String companyAddress;
    private ItemType item;
    private ServiceType service;
    private long priceOfService;
    private ItemType itemType;
    private long priceForServiceOfItem;

}
