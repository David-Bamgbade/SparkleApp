package com.SparkleApp.web;

import com.SparkleApp.Dto.request.CreateLaundryMarketPostRequest;
import com.SparkleApp.Dto.request.UpdateLaundryMarketPostRequest;
import com.SparkleApp.Dto.response.ApiResponse;
import com.SparkleApp.Dto.response.CreateLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.DeleteLaundryMarketPostResponse;
import com.SparkleApp.Dto.response.UpdateLaundryMarketPostResponse;
import com.SparkleApp.Services.LaundererMarketService;
import com.SparkleApp.data.models.LaundryMarket;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laundryMarket/")
@RequiredArgsConstructor
public class LaundryMarketController {


    @Autowired
    private LaundererMarketService laundererMarketService;


    @PostMapping("/createPost")
    public ResponseEntity<?>  createPost(@RequestBody CreateLaundryMarketPostRequest createLaundryMarketPostRequest){
        try {
            CreateLaundryMarketPostResponse createLaundryMarketPostResponse = laundererMarketService.createPost(createLaundryMarketPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, createLaundryMarketPostResponse),
                    HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/updatePost")
    public ResponseEntity<?> updatePost(@RequestBody UpdateLaundryMarketPostRequest laundryMarketPostRequest){
        try {
            UpdateLaundryMarketPostResponse updateLaundryMarketPostResponse = laundererMarketService.updatePost(laundryMarketPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateLaundryMarketPostResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        try {
            DeleteLaundryMarketPostResponse marketPostResponse = laundererMarketService.deletePost(id);
            return new ResponseEntity<>(new ApiResponse(true, marketPostResponse),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllLaundryMarket(){
        try {
            List<LaundryMarket> findAllLaundryMarketPost = laundererMarketService.findAllLaundryMarketPosts();
            return new ResponseEntity<>(new ApiResponse(true, findAllLaundryMarketPost),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searchLaundryMarketPostByCompanyName/{companyName}")
    public ResponseEntity<?> searchLaundryMarketPostByCompanyName(@PathVariable String companyName){
        try {
            List<LaundryMarket> findLaundryMarketPostByCompanyName = laundererMarketService
                    .findLaundryMarketPostByCompanyName(companyName);
            return new ResponseEntity<>(new ApiResponse(true, findLaundryMarketPostByCompanyName),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchLaundryMarketPostByCompanyDescription/{companyDescription}")
    public ResponseEntity<?> searchLaundryMarketPostByCompanyDescription(@PathVariable String companyDescription){
        try {
            List<LaundryMarket> findLaundryMarketPostByCompanyDescription = laundererMarketService.findLaundryMarketPostByServiceDescription(companyDescription);
            return new ResponseEntity<>(new ApiResponse(true, findLaundryMarketPostByCompanyDescription),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchLaundryMarketPostByCompanyAddress/{companyAddress}")
    public ResponseEntity<?> searchLaundryMarketPostByCompanyAddress(@PathVariable String companyAddress){
        try {
            List<LaundryMarket> findLaundryMarketPostByCompanyAddress = laundererMarketService.findLaundryMarketPostByCompanyAddress(companyAddress);
            return new ResponseEntity<>(new ApiResponse(true, findLaundryMarketPostByCompanyAddress),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ searchLaundryMarketPostByServiceName/{serviceName}")
    public ResponseEntity<?> searchLaundryMarketPostByServiceName(@PathVariable String serviceName){
        try {
            List<LaundryMarket> findLaundryMarketPostByServiceName = laundererMarketService.findLaundryMarketPostByServiceName(serviceName);
            return new ResponseEntity<>(new ApiResponse(true, findLaundryMarketPostByServiceName),
                    HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }
}
