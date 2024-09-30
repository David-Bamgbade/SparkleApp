package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {

        Optional<OrderPlacement> findByOrderId(Long orderId);

    }
