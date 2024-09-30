package com.SparkleApp.data.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Setter
@Getter
public class CartItems {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String serviceName;
        private double price;
        private int quantity;

        @ManyToOne
        @JoinColumn(name = "cart_id")
        private Cart cart;



}
