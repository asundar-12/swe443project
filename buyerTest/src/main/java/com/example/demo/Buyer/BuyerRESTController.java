package com.example.demo.Buyer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/buyerREST")
public class BuyerRESTController {

    public BuyerRESTController(){
        this.restTemplate = new RestTemplate();
    }


    private final RestTemplate restTemplate;
    @PostMapping("/receiveListingId")
    public Integer receiveListingId(@RequestBody Integer listingId) {
        // Logic to handle the received listingId from the request body
        System.out.println("Received Listing ID: " + listingId);
        return listingId;
    }
    @PostMapping("/getSavedListingsData")
    public  ResponseEntity<List> getSavedListingsData(@RequestBody List<Integer> listingIds) {
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/listings";
        HttpEntity<List<Integer>> request = new HttpEntity<List<Integer>>(
                listingIds);
        // Send the PUT method as a method parameter
        ResponseEntity<List> strings = restTemplate.exchange(
                listingsUrl,
                HttpMethod.POST,
                request,
                List.class);
        System.out.println(strings.getBody());
        return strings;
    }


}
