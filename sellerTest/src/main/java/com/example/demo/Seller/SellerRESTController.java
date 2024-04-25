package com.example.demo.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/sellerREST")
public class SellerRESTController {

    @Autowired
    public SellerRESTController(OfferIdService offerIdService){
        this.offerIdService = offerIdService;
        this.restTemplate = new RestTemplate();
    }

    private final OfferIdService offerIdService;
    private final RestTemplate restTemplate;
    @PostMapping("/receiveOfferId")
    public Integer receiveOfferId(@RequestBody Integer offerId) {
        System.out.println("Received offer ID: " + offerId);
        OfferId newOfferId = new OfferId(offerId);
        offerIdService.addOfferId(newOfferId);
        return offerId;
    }
    @PostMapping("/submitListing")
    public void submitListing(@RequestBody HashMap<String, Object> listing){
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/newListing";
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(
                listing);
        ResponseEntity<String> submittedListing = restTemplate.exchange(
                listingsUrl,
                HttpMethod.POST,
                request,
                String.class);
        System.out.println(submittedListing.getBody());
    }
    @PostMapping("/getOfferIdsData")
    public ResponseEntity<List> getOfferIdsData() {
        List<OfferId> offerIds = offerIdService.fetchOfferIds();
        List<Integer> requestList = new ArrayList<>();
        for(OfferId offerId: offerIds){
            System.out.println("Here is the offerid: " + offerId.getofferid());
            requestList.add(offerId.getofferid());
        }
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/offers";
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