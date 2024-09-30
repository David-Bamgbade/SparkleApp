package com.SparkleApp.data.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderPlacementRepository<OrderPlacement> extends JpaRepository<OrderPlacement, Long> {


        void deleteById(Long orderId);


        Optional<OrderPlacement> findById(Long orderId);

        List<OrderPlacement> findAll();
    }
