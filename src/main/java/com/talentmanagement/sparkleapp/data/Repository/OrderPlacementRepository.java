package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPlacementRepository extends JpaRepository<OrderPlacement, Long> {


}
