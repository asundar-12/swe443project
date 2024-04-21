package com.example.demo.Seller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/sellerREST")
public class SellerRESTController {

    public SellerRESTController(){
        this.restTemplate = new RestTemplate();
    }


    private final RestTemplate restTemplate;
    @PostMapping("/receiveOfferId")
    public Integer receiveOfferId(@RequestBody Integer offerId) {
        // Logic to handle the received offerId from the request body
        System.out.println("Received offer ID: " + offerId);
        return offerId;
    }
    @PostMapping("/submitListing")
    public void submitListing(@RequestBody HashMap<String, Object> listing){
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/offers";
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(
                listing);
        ResponseEntity<String> submittedListing = restTemplate.exchange(
                listingsUrl,
                HttpMethod.POST,
                request,
                String.class);
        System.out.println(submittedListing.getBody());
    }
    @PostMapping("/getOffersData")
    public ResponseEntity<List> getOffersData(@RequestBody List<Integer> offerIds) {
        String offersUrl = "http://localhost:9000/api/v1/mainREST/offers";
        HttpEntity<List<Integer>> request = new HttpEntity<List<Integer>>(
                offerIds);
        // Send the PUT method as a method parameter
        ResponseEntity<List> strings = restTemplate.exchange(
                offersUrl,
                HttpMethod.POST,
                request,
                List.class);
        System.out.println(strings.getBody());
        return strings;
    }


}
