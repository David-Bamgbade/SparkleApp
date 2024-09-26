package com.SparkleApp.data.Repository;

import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.LaundererMarket;
import com.SparkleApp.data.models.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundererMarketRepository extends JpaRepository<LaundererMarket, Long> {
    LaundererMarket findByFirstName(String name);



}
