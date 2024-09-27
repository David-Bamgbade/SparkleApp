package com.talentmanagement.sparkleapp.Services;

import com.talentmanagement.sparkleapp.Dto.request.CreateLaundererMarketPostRequest;
import com.talentmanagement.sparkleapp.Dto.response.CreateLaundererMarketPostResponse;
import com.talentmanagement.sparkleapp.data.models.Launderer;
import com.talentmanagement.sparkleapp.data.models.LaundererMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundererMarketService{

    CreateLaundererMarketPostResponse createPost(CreateLaundererMarketPostRequest createLaundererMarketPostRequest);



}
