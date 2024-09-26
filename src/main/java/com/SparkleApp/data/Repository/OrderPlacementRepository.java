package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {
    OrderPlacement findByOrderId(Long orderId);


}
