package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;
import com.SparkleApp.data.Repository.LaundererMarketRepository;
import com.SparkleApp.data.models.LaundryMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.SparkleApp.utils.Mapper.postMap;
import static com.SparkleApp.utils.Mapper.postMapResponse;

@Service
public class LaundererMarketServiceImpl implements  LaundererMarketService{

    @Autowired
    private LaundererMarketRepository laundererMarketRepository;


    @Override
    public CreateLaundryMarketPostResponse createPost(CreateLaundryMarketPostRequest laundererMarketRequest) {
        LaundryMarket laundryMarket = new LaundryMarket();
        postMap(laundererMarketRequest, laundryMarket);
        laundererMarketRepository.save(laundryMarket);
        return postMapResponse(laundryMarket);
    }

    @Override
    public UpdateLaundryMarketPostResponse updatePost(UpdateLaundryMarketPostRequest laundererMarketPostRequest) {

        return null;
    }
}
