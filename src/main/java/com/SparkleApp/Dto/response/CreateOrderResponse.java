package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderResponse {
    private String message;
    private Long id;
    private Long customerId;
}
