package com.talentmanagement.sparkleapp.Dto.request;

import com.talentmanagement.sparkleapp.data.models.ItemType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaundererSendRequest {
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerAddress;
    private String companyName;
    private String companyNumber;
    private String nameOfItems;
    private int NumberOfItems;
    private long totalPrice;
    private boolean paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private ItemType itemType;

}
