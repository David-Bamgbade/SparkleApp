package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.data.models.Launderer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundererMarketService extends JpaRepository<Launderer, Long> {


}
