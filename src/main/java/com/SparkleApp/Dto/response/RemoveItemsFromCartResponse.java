package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemoveItemsFromCartResponse {
    private String itemId;
    private String message;
}
