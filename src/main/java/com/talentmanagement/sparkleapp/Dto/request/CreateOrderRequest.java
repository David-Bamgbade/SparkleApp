package com.talentmanagement.sparkleapp.Dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
public class CreateOrderRequest {
    public LocalDateTime getPickUpDate;
    private Long customerId;
    private LocalDateTime pickUpDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private Double totalCost;
}