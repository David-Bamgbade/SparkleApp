package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {
    OrderPlacement findByOrderId(Long orderId);


}
