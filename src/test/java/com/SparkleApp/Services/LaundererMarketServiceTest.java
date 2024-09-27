package com.SparkleApp.Services;
import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.data.Repository.LaundererMarketRepository;
import com.SparkleApp.data.models.ItemType;
import com.SparkleApp.data.models.ServiceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}