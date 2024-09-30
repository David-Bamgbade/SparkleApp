package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.AddItemToCartRequest;
import com.SparkleApp.Dto.request.CheckoutRequest;
import com.SparkleApp.Dto.request.RemoveItemsToCartRequest;
import com.SparkleApp.Dto.response.AddItemsToCartResponse;
import com.SparkleApp.Dto.response.CheckoutResponse;
import com.SparkleApp.Dto.response.RemoveItemsFromCartResponse;
import com.SparkleApp.data.Repository.CartRepository;
import com.SparkleApp.data.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public AddItemsToCartResponse AddItemsToCart(AddItemToCartRequest request) {
        Cart cart = new Cart();
        cart.setItems(request.getItems());
        cartRepository.save(cart);
        AddItemsToCartResponse addItemsToCartResponse = new AddItemsToCartResponse();
        addItemsToCartResponse.setMessage("Added items to cart");
        return addItemsToCartResponse;
    }

    @Override
    public RemoveItemsFromCartResponse RemoveItemsFromCart(RemoveItemsToCartRequest request) {




        return null;
    }

    @Override
    public CheckoutResponse Checkout(CheckoutRequest request) {
        return null;
    }
}
