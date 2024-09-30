package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.CartItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddItemToCartRequest {

    private List<CartItems> items;

}
