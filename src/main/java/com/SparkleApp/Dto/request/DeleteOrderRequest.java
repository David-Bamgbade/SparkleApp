package com.SparkleApp.Dto.request;


import lombok.Data;

@Data
public class DeleteOrderRequest {
    private Long orderId;
    private Long customerId;
}

