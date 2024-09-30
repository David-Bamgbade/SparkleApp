package com.SparkleApp;

import com.SparkleApp.Dto.request.CreateOrderRequest;
import com.SparkleApp.Dto.request.DeleteOrderRequest;
import com.SparkleApp.Dto.request.UpdateOrderRequest;
import com.SparkleApp.Dto.response.CreateOrderResponse;
import com.SparkleApp.Dto.response.DeleteOrderResponse;
import com.SparkleApp.Dto.response.UpdateOrderResponse;
import com.SparkleApp.Services.OrderPlacementService;
import com.SparkleApp.data.models.OrderPlacement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderPlacementServiceTest {
    @Autowired
    private OrderPlacementService orderPlacementService;

    @Test
    public void testThatOrderCanBePlaced() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrderDate(LocalDateTime.now());
        request.setDeliveryDate(LocalDateTime.now().plusDays(5));
        request.setPickUpDate(LocalDateTime.now().plusDays(1));
        request.setTotalCost(2000.0);
        Long customerId = 1L;

        CreateOrderResponse response = orderPlacementService.createOrder(request);
        assertNotNull(response);
        assertEquals("Order Placed Successfully", response.getMessage());
        assertEquals(2000.0, request.getTotalCost());

    }
    @Test
    public void testThatOrderCanBeDeleted() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrderDate(LocalDateTime.now());
        request.setDeliveryDate(LocalDateTime.now().plusDays(5));
        request.setPickUpDate(LocalDateTime.now().plusDays(1));
        request.setTotalCost(2000.0);
        request.setCustomerId(5L);
        CreateOrderResponse response = orderPlacementService.createOrder(request);
        assertNotNull(response);
        assertEquals("Order Placed Successfully", response.getMessage());
        DeleteOrderRequest request2 = new DeleteOrderRequest();
        request2.setOrderId(response.getId());
//        request2.setCustomerId(response.getCustomerId());
        DeleteOrderResponse response2 = orderPlacementService.deleteOrder(request2.getOrderId());
        assertEquals("Order Deleted Successfully", response2.getMessage());

    }
    @Test
    public void testThatOrderCanBeUpdated() throws Throwable {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrderDate(LocalDateTime.now());
        request.setDeliveryDate(LocalDateTime.now().plusDays(5));
        request.setPickUpDate(LocalDateTime.now().plusDays(1));
        request.setTotalCost(2000.0);
        request.setCustomerId(5L);
        CreateOrderResponse response = orderPlacementService.createOrder(request);
        assertNotNull(response);
        assertEquals("Order Placed Successfully", response.getMessage());
        UpdateOrderRequest request2 = new UpdateOrderRequest();
        request2.setOrderDate(LocalDateTime.now());
        request.setDeliveryDate(LocalDateTime.now().plusDays(5));
        request.setPickUpDate(LocalDateTime.now().plusDays(1));
        request.setTotalCost(2000.0);
        UpdateOrderResponse response1 = orderPlacementService.updateOrder(response.getId(),request2);
        assertEquals("Order Updated Successfully", response1.getMessage());
    }

    @Test
    public void testThatOrderCanBeRetrieved() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrderDate(LocalDateTime.now());
        request.setDeliveryDate(LocalDateTime.now().plusDays(5));
        request.setPickUpDate(LocalDateTime.now().plusDays(1));
        request.setTotalCost(2000.0);
        request.setCustomerId(5L);
        orderPlacementService.createOrder(request);
        CreateOrderRequest request2 = new CreateOrderRequest();
        request2.setOrderDate(LocalDateTime.now());
        request2.setDeliveryDate(LocalDateTime.now().plusDays(2));
        request2.setPickUpDate(LocalDateTime.now().plusDays(3));
        request2.setTotalCost(5000.0);
        request2.setCustomerId(3L);
        orderPlacementService.createOrder(request2);
        List<OrderPlacement> allOrders = orderPlacementService.findAll();




    }
}
