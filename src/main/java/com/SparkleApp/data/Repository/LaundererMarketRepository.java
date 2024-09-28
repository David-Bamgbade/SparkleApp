package com.SparkleApp.data.Repository;


import com.SparkleApp.data.models.LaundryMarket;
import com.SparkleApp.data.models.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LaundererMarketRepository extends JpaRepository<LaundryMarket, Long> {

    List<LaundryMarket> findLaundryMarketPostByCompanyName(String companyAddress);

    List<LaundryMarket> findLaundryMarketPostByCompanyAddress(String companyAddress);

    List<LaundryMarket> findLaundryMarketPostByServiceDescription(String serviceDescription);

    boolean existsByCompanyPhoneNumber(String companyPhoneNumber);

    boolean existsByService(ServiceType service);

}
