package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.CreateOrderRequest;
import com.talentmanagement.sparkleapp.Dto.request.UpdateOrderRequest;
import com.talentmanagement.sparkleapp.Dto.response.CreateOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.DeleteOrderResponse;
import com.talentmanagement.sparkleapp.Dto.response.UpdateOrderResponse;
import com.talentmanagement.sparkleapp.data.Repository.OrderPlacementRepository;
import com.talentmanagement.sparkleapp.data.models.OrderPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPlacementServiceImpl implements OrderPlacementService {

    @Autowired
    private OrderPlacementRepository placementRepository;


    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        OrderPlacement orderPlacement = new OrderPlacement();
        orderPlacement.setPickUpDate(createOrderRequest.getPickUpDate());
        orderPlacement.setDeliveryDate(createOrderRequest.getDeliveryDate());
        orderPlacement.setOrderDate(createOrderRequest.getOrderDate());
        orderPlacement.setTotalCost(createOrderRequest.getTotalCost());
        orderPlacement.setCustomerId(createOrderRequest.getCustomerId());
        OrderPlacement order = placementRepository.save(orderPlacement);
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setId(order.getId());
        createOrderResponse.setCustomerId(order.getCustomerId());
        createOrderResponse.setMessage("Order Placed Successfully");
        return createOrderResponse;
    }

    @Override
    public DeleteOrderResponse deleteOrder(Long orderId) {
        placementRepository.deleteById(orderId);
        DeleteOrderResponse deleteOrderResponse = new DeleteOrderResponse();
        deleteOrderResponse.setMessage("Order Deleted Successfully");
        return deleteOrderResponse;
    }

    @Override
    public UpdateOrderResponse updateOrder(Long orderId, UpdateOrderRequest updateOrderRequest) {
        OrderPlacement orderPlacement = findById(orderId);
        orderPlacement.setOrderDate(updateOrderRequest.getOrderDate());
        orderPlacement.setPickUpDate(updateOrderRequest.getPickUpDate());
        orderPlacement.setDeliveryDate(updateOrderRequest.getDeliveryDate());
        orderPlacement.setTotalCost(updateOrderRequest.getTotalCost());
        placementRepository.save(orderPlacement);
        UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
        updateOrderResponse.setMessage("Order Updated Successfully");
        return updateOrderResponse;

    }

    private  OrderPlacement findById(Long orderId) {
        return placementRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<OrderPlacement> findAll() {
        placementRepository.findAll();
        return placementRepository.findAll();
    }


}

