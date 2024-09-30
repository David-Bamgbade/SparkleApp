package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutRequest {
    private String cartId;
    private String totalAmount;

}
