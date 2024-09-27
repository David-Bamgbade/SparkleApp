package com.SparkleApp.data.Repository;


import com.SparkleApp.data.models.LaundryMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundererMarketRepository extends JpaRepository<LaundryMarket, Long> {




}
