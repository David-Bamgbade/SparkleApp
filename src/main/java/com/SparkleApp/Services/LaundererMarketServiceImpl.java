package com.SparkleApp.Services;

import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.DeleteLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;
import com.SparkleApp.data.Repository.LaundererMarketRepository;
import com.SparkleApp.data.models.LaundryMarket;
import com.SparkleApp.exception.IdNotFoundException;
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
        LaundryMarket laundryMarket = getLaundryMarket(laundererMarketPostRequest);
        laundererMarketRepository.save(laundryMarket);
        return getUpdateLaundryMarketPostResponse(laundryMarket);
    }

    @Override
    public DeleteLaundryMarketPostResponse deletePost(Long id) {
        LaundryMarket laundryMarket = findLaundryMarketById(id);
        laundererMarketRepository.delete(laundryMarket);
        DeleteLaundryMarketPostResponse laundryMarketPostResponse = new DeleteLaundryMarketPostResponse();
        laundryMarketPostResponse.setMessage("Delete successfully");
        return laundryMarketPostResponse;
    }

    private LaundryMarket findLaundryMarketById(Long id) {
        return laundererMarketRepository.findById(id)
                .orElseThrow(()-> new IdNotFoundException("Laundry market id not found"));
    }

    private static UpdateLaundryMarketPostResponse getUpdateLaundryMarketPostResponse(LaundryMarket laundryMarket) {
        UpdateLaundryMarketPostResponse laundryMarketPostResponse = new UpdateLaundryMarketPostResponse();
        laundryMarketPostResponse.setServiceName(laundryMarket.getServiceName());
        laundryMarketPostResponse.setServiceDescription(laundryMarket.getServiceDescription());
        laundryMarketPostResponse.setPriceForServiceOfItem(laundryMarket.getPriceForServiceOfItem());
        laundryMarketPostResponse.setService(laundryMarket.getService().WASH_AND_IRON);
        laundryMarketPostResponse.setItem(laundryMarketPostResponse.getItem().HOODIE);
        laundryMarketPostResponse.setCompanyName(laundryMarket.getCompanyName());
        laundryMarketPostResponse.setCompanyPhoneNumber(laundryMarket.getCompanyPhoneNumber());
        laundryMarketPostResponse.setCompanyAddress(laundryMarket.getCompanyAddress());
        laundryMarketPostResponse.setMessage("Post updated successfully");
        return laundryMarketPostResponse;
    }

    private static LaundryMarket getLaundryMarket(UpdateLaundryMarketPostRequest laundererMarketPostRequest) {
        LaundryMarket laundryMarket = new LaundryMarket();
        laundryMarket.setServiceName(laundererMarketPostRequest.getServiceName());
        laundryMarket.setServiceDescription(laundryMarket.getServiceDescription());
        laundryMarket.setPriceForServiceOfItem(laundryMarket.getPriceForServiceOfItem());
        laundryMarket.setService(laundererMarketPostRequest.getService().WASH_AND_IRON);
        laundryMarket.setItem(laundererMarketPostRequest.getItem().HOODIE);
        laundryMarket.setCompanyName(laundryMarket.getCompanyName());
        laundryMarket.setCompanyAddress(laundererMarketPostRequest.getCompanyAddress());
        laundryMarket.setCompanyPhoneNumber(laundererMarketPostRequest.getCompanyPhoneNumber());
        return laundryMarket;
    }


}
