package com.dejiOrder.code.controller;

import com.SparkleApp.data.Repository.OrderPlacementRepository;
import com.SparkleApp.data.models.OrderPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderPlacementController {

    @Autowired
    private OrderPlacementRepository orderPlacementRepository;


    @PostMapping
    public ResponseEntity<OrderPlacement> createOrder(@RequestBody OrderPlacement orderPlacement) {
        OrderPlacement savedOrder = (OrderPlacement) orderPlacementRepository.save(orderPlacement);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<OrderPlacement>> getAllOrders() {
        List<OrderPlacement> orders = orderPlacementRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderPlacement> getOrderById(@PathVariable Long id) {
        return (ResponseEntity<OrderPlacement>) orderPlacementRepository.findById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderPlacement> updateOrder(@PathVariable Long id, @RequestBody OrderPlacement orderPlacement) {
        if (!orderPlacementRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderPlacement.setId(id);
        OrderPlacement updatedOrder = (OrderPlacement) orderPlacementRepository.save(orderPlacement);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderPlacementRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderPlacementRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}