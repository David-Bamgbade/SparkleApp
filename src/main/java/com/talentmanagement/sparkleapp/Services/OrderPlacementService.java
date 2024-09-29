package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.CreateOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.CreateOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.DeleteOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.UpdateOrderResponse;
import com.talentmanagement.sparkleapp.data.models.OrderPlacement;

import java.util.List;

public interface OrderPlacementService {


    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    DeleteOrderResponse deleteOrder(Long orderId);

    UpdateOrderResponse updateOrder(Long orderId, UpdateOrderRequest updateOrderRequest);

    List<OrderPlacement> findAll();


}

