package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemoveItemsToCartRequest {
    public Long getCartId;
    private String itemId;

}
