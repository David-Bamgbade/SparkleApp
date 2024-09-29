package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.AddItemToCartRequest;
import com.SparkleApp.Dto.request.CheckoutRequest;
import com.SparkleApp.Dto.request.RemoveItemsToCartRequest;
import com.SparkleApp.Dto.response.AddItemsToCartResponse;
import com.SparkleApp.Dto.response.CheckoutResponse;
import com.SparkleApp.Dto.response.RemoveItemsFromCartResponse;

public interface CartService {
    AddItemsToCartResponse AddItemsToCart(AddItemToCartRequest request);
    RemoveItemsFromCartResponse RemoveItemsFromCart(RemoveItemsToCartRequest request);
    CheckoutResponse Checkout(CheckoutRequest request);
}
