package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.DeleteLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;
import com.SparkleApp.data.models.Customer;
import com.SparkleApp.data.models.LaundryMarket;

import java.util.List;

public interface LaundererMarketService{

    CreateLaundryMarketPostResponse createPost(CreateLaundryMarketPostRequest laundererMarketRequest);

    UpdateLaundryMarketPostResponse updatePost(UpdateLaundryMarketPostRequest laundererMarketPostRequest);

    DeleteLaundryMarketPostResponse deletePost(Long id);

    List<LaundryMarket> findLaundryMarketPostByServiceName(String serviceName);

    List<LaundryMarket> findLaundryMarketPostByServiceDescription(String serviceDescription);

    List<LaundryMarket> findLaundryMarketPostByCompanyName(String companyName);

    List<LaundryMarket> findLaundryMarketPostByCompanyAddress(String companyAddress);

    List<LaundryMarket> findAllLaundryMarketPosts();

}
