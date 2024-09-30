package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UpdateOrderRequest {
    private LocalDateTime pickUpDate;
    private LocalDateTime deliveryDate;
    private LocalDateTime orderDate;
    private Double totalCost;
}
