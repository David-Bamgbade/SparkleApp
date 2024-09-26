package com.talentmanagement.sparkleapp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickupRiderRequest {
    private int pickupId;
    private String pickupCustomerName;
    private String pickupAddress;
    private String pickupPhoneNumber;


}