package com.talentmanagement.sparkleapp.Dto.request;


import lombok.Data;

@Data
public class DeleteOrderRequest {
    private Long orderId;
    private Long customerId;
}

