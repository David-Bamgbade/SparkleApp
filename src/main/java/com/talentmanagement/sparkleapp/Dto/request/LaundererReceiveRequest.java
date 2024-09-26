package com.talentmanagement.sparkleapp.Dto.request;

import com.talentmanagement.sparkleapp.data.models.ItemType;
import com.talentmanagement.sparkleapp.data.models.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaundererReceiveRequest {
    private String firstName;
    private String lastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;
    private long totalServicePrice;
    private String serviceType;
    private int NumberOfItems;
    private long pricePerService;
    private boolean paymentStatus;
    private String servicePerItem;
    private ServiceType service;
    private ItemType item;
}
