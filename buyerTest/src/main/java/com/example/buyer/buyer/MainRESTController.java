package com.example.buyer.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/buyerAccount")
public class MainRESTController {
    RestTemplate restTemplate;
    private final BuyerAccountService buyerAccountService;
    private final SavedListingIdsService savedListingIdsService;

    @Autowired
    public MainRESTController(BuyerAccountService buyerAccountService, SavedListingIdsService savedListingIdsService) {
        this.savedListingIdsService = savedListingIdsService;
        this.buyerAccountService = buyerAccountService;
        this.restTemplate = new RestTemplate();
    }


    @PostMapping("/receiveListingId")
    public void receiveListingId(@RequestBody int listingId){
        System.out.println("Received Listing ID: " + listingId);
        SavedListingIds newSavedListingId = new SavedListingIds(listingId);
        savedListingIdsService.addSavedListingId(newSavedListingId);
    }

    @PostMapping("/getSavedListingsData")
    public ResponseEntity<List> getSavedListingsData() {
        List<SavedListingIds> listingIds = savedListingIdsService.fetchSavedListings();
        List<Integer> requestList = new ArrayList<>();
        for(SavedListingIds listingId: listingIds){
            requestList.add(listingId.getListingid());
        }
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/listings";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Integer>> request = new HttpEntity<List<Integer>>(
                requestList);
        ResponseEntity<List> responses = restTemplate.exchange(
                listingsUrl,
                HttpMethod.POST,
                request,
                List.class);
        System.out.println(responses.getBody());
        return responses;
    }

}