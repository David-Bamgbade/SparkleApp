package com.SparkleApp.Services;
import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.DeleteLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;
import com.SparkleApp.data.Repository.LaundererMarketRepository;
import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LaundererMarketServiceTest {

    @Autowired
    private LaundererMarketRepository laundererMarketRepository;

    @Autowired
    private LaundererMarketService laundererMarketService;

    @BeforeEach
    void setUp() {
        laundererMarketRepository.deleteAll();
    }

    @Test
    public void testThatLaunderersCanPostTheirServiceInTheLaundryMarketPlace(){
        CreateLaundryMarketPostRequest laundryMarketPostRequest = new CreateLaundryMarketPostRequest();
        laundryMarketPostRequest.setServiceName("Shirt");
        laundryMarketPostRequest.setServiceDescription("A thick shirt");
        laundryMarketPostRequest.setPriceForServiceOfItem(500);
        laundryMarketPostRequest.setItem(ItemType.HOODIE);
        laundryMarketPostRequest.setService(ServiceType.IRON_ONLY);
        laundryMarketPostRequest.setCompanyName("Sus Laundry");
        laundryMarketPostRequest.setCompanyPhoneNumber("08123115688");
        CreateLaundryMarketPostResponse laundryMarketPostResponse = laundererMarketService.createPost(laundryMarketPostRequest);
        assertEquals(laundryMarketPostResponse.getMessage(),"Posted successfully");
    }

    @Test
    public void testThatLaundererMarketPostCanBeUpdated(){
        CreateLaundryMarketPostRequest laundryMarketPostRequest = new CreateLaundryMarketPostRequest();
        laundryMarketPostRequest.setServiceName("Shirt");
        laundryMarketPostRequest.setServiceDescription("A thick shirt");
        laundryMarketPostRequest.setPriceForServiceOfItem(500);
        laundryMarketPostRequest.setItem(ItemType.HOODIE);
        laundryMarketPostRequest.setService(ServiceType.IRON_ONLY);
        laundryMarketPostRequest.setCompanyName("Sus Laundry");
        laundryMarketPostRequest.setCompanyPhoneNumber("08123115688");
        CreateLaundryMarketPostResponse laundryMarketPostResponse = laundererMarketService.createPost(laundryMarketPostRequest);
        assertThat(laundryMarketPostResponse.getMessage()).contains("Posted successfully");
        UpdateLaundryMarketPostRequest updateLaundryMarketPostRequest = getUpdateLaundryMarketPostRequest();
        UpdateLaundryMarketPostResponse marketPostResponse = laundererMarketService.updatePost(updateLaundryMarketPostRequest);
        assertThat(marketPostResponse.getMessage()).contains("Post updated successfully");
    }

    private static UpdateLaundryMarketPostRequest getUpdateLaundryMarketPostRequest() {
        UpdateLaundryMarketPostRequest updateLaundryMarketPostRequest = new UpdateLaundryMarketPostRequest();
        updateLaundryMarketPostRequest.setServiceName("Kim");
        updateLaundryMarketPostRequest.setServiceDescription("Dayo");
        updateLaundryMarketPostRequest.setPriceForServiceOfItem(2500);
        updateLaundryMarketPostRequest.setService(ServiceType.WASH_AND_IRON);
        updateLaundryMarketPostRequest.setItem(ItemType.SHIRT);
        updateLaundryMarketPostRequest.setCompanyName("Sarvita laundry");
        updateLaundryMarketPostRequest.setCompanyPhoneNumber("0901232322");
        updateLaundryMarketPostRequest.setCompanyAddress("Sabo");
        return updateLaundryMarketPostRequest;
    }

    @Test
    public void testThatLaundererMarketServiceCanBeDeleted(){
        CreateLaundryMarketPostRequest laundryMarketPostRequest = new CreateLaundryMarketPostRequest();
        laundryMarketPostRequest.setServiceName("Shirt");
        laundryMarketPostRequest.setServiceDescription("A thick shirt");
        laundryMarketPostRequest.setPriceForServiceOfItem(500);
        laundryMarketPostRequest.setItem(ItemType.HOODIE);
        laundryMarketPostRequest.setService(ServiceType.IRON_ONLY);
        laundryMarketPostRequest.setCompanyName("Sus Laundry");
        laundryMarketPostRequest.setCompanyPhoneNumber("08123115688");
        CreateLaundryMarketPostResponse laundryMarketPostResponse = laundererMarketService.createPost(laundryMarketPostRequest);
        assertEquals(laundryMarketPostResponse.getMessage(),"Posted successfully");
        Long id = laundryMarketPostResponse.getLaundererId();
        DeleteLaundryMarketPostResponse marketPostResponse = laundererMarketService.deletePost(id);
        assertThat(marketPostResponse.getMessage()).contains("Delete successfully");
    }

    

}