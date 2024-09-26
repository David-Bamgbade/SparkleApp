package com.talentmanagement.sparkleapp.data.Repository;

import com.talentmanagement.sparkleapp.data.models.ItemType;
import com.talentmanagement.sparkleapp.data.models.LaundererMarket;
import com.talentmanagement.sparkleapp.data.models.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundererMarketRepository extends JpaRepository<LaundererMarket, Long> {
    LaundererMarket findByName(String name);
    LaundererMarket findAllByService(ServiceType serviceType);
    LaundererMarket findAllByServiceType(ItemType itemType);


}
