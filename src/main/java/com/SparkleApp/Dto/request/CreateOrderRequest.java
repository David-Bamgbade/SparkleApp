package com.SparkleApp.Dto.request;


import lombok.Getter;
import lombok.Setter;

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