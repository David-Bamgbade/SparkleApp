package com.talentmanagement.sparkleapp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class OrderPlacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setCustomerId(Long customerId) {
    }

    public void setTotalCost(Double totalCost) {
    }

    public void setOrderDate(LocalDateTime orderDate) {
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
    }

    public Long getCustomerId() {
    }
}
