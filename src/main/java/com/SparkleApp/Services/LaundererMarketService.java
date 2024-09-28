package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.DeleteLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;

public interface LaundererMarketService{

    CreateLaundryMarketPostResponse createPost(CreateLaundryMarketPostRequest laundererMarketRequest);

    UpdateLaundryMarketPostResponse updatePost(UpdateLaundryMarketPostRequest laundererMarketPostRequest);

    DeleteLaundryMarketPostResponse deletePost(Long id);

}
