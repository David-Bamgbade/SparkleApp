package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CreateOrderRequest;
import com.SparkleApp.Dto.request.UpdateOrderRequest;
import com.SparkleApp.Dto.response.CreateOrderResponse;
import com.SparkleApp.Dto.response.DeleteOrderResponse;
import com.SparkleApp.Dto.response.UpdateOrderResponse;
import com.SparkleApp.data.models.OrderPlacement;

import java.util.List;

public interface OrderPlacementService {


    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    DeleteOrderResponse deleteOrder(Long orderId);

    UpdateOrderResponse updateOrder(Long orderId, UpdateOrderRequest updateOrderRequest) throws Throwable;

    List<OrderPlacement> findAll();


}

