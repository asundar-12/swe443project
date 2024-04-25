package com.example.demo.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private final SellerService sellerService;
    private final RestTemplate restTemplate;

    @Autowired
    public SellerController(SellerService sellerService, RestTemplate restTemplate) {
        this.sellerService = sellerService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @PostMapping("/receiveOfferId")
    public void receiveOfferId(@RequestParam("offerId") int offerId){
        System.out.println("Received Offer ID: " + offerId);
        sellerService.addOfferIdToSeller(offerId);
    }

    @PostMapping("/submitListing")
    public void submitListing(@RequestBody HashMap<String, Object> listing){
        String listingsUrl = "http://localhost:9000/api/v1/mainREST/offers";
        HttpEntity<HashMap<String, Object>> request = new HttpEntity<>(listing);
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
        HttpEntity<List<Integer>> request = new HttpEntity<>(offerIds);
        ResponseEntity<List> response = restTemplate.exchange(
                offersUrl,
                HttpMethod.POST,
                request,
                List.class);
        System.out.println(response.getBody());
        return response;
    }
}
