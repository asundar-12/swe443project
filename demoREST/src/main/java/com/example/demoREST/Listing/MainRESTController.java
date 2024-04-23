package com.example.demoREST.Listing;


import com.example.demoREST.Offer.Offer;
import com.example.demoREST.Offer.OfferService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value="api/v1/mainREST")
public class MainRESTController {

    private final ListingService listingService;
    private final OfferService offerService;
    @Autowired
    public MainRESTController(ListingService listingService, OfferService offerService) {
        this.listingService = listingService;
        this.offerService = offerService;
        this.restTemplate = new RestTemplate();
    }

    private final RestTemplate restTemplate;

    @PostMapping(value = "/sendListingId")
    public Integer sendListingId(@RequestBody int listingId) {
        String buyerMicroserviceUrl = "http://localhost:6060/buyerAccount/receiveListingId";
//        String buyerMicroserviceUrl = "http://l/buyerAccount/receiveListingId";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity <Integer> entity = new HttpEntity<Integer>(listingId, headers);
        System.out.println("Listing ID: " + listingId);
        return restTemplate.postForObject(buyerMicroserviceUrl, entity, Integer.class);
    }

    @PostMapping(value="/sendOfferId")
    public Integer sendOfferId(@RequestBody int offerid){
        System.out.println("The offerid is: " + offerid);
//        String sellerMicroserviceUrl = "http://localhost:7070/api/v1/sellerREST/receiveOfferId";
        String sellerMicroserviceUrl = "http://10.166.183.140:7070/api/v1/sellerREST/receiveOfferId";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity <Integer> entity = new HttpEntity<Integer>(offerid, headers);
        System.out.println("Offer ID: " + offerid);

        return restTemplate.postForObject(sellerMicroserviceUrl, entity, Integer.class);
    }

    @PostMapping("/listings")
    public List getSavedListings(@RequestBody List<Integer> listingIds){
        List<Map<String, Object>> responseListings = new ArrayList<>();
        System.out.println("Size " + listingIds.size());
//        for(Integer id: listingIds){
//            responseListings.add(listingService.getListing(id).toString());
//        }

          for(Integer id: listingIds){
              HashMap<String, Object> listingObj = new HashMap<>();
              Listing listing = listingService.getListing(id).orElseThrow(()-> new IllegalStateException("listing with THAT mlsid does not exist"));
              listingObj.put("address", listing.getAddress());
              listingObj.put("price", listing.getPrice());
              listingObj.put("type", listing.getType());
              listingObj.put("listeddate", listing.getListeddate());
              responseListings.add(listingObj);
          }
        return responseListings;
    }
    @PostMapping("/offers")
    public List<String> getOffers(@RequestBody List<Integer> offerIds){
        List<String> responseOffers = new ArrayList<>();
        for(Integer id: offerIds){
            responseOffers.add(offerService.getOffer(id).toString());
        }
        System.out.println("Response OFfers arraylist: " + responseOffers);
        return responseOffers;
    }

    @PutMapping("/offer/{offerid}")
    public void updateOffer(@RequestParam int offerid, @RequestParam String status){
        offerService.updateOffer(offerid, status);
    }


}
//
//@RestController
////@Controller
//@RequestMapping(path="api/v1/listing")
//public class MainRESTController {
//
//    private final ListingService listingService;
//
//    @Autowired
//    public MainRESTController(ListingService listingService) {
//        this.listingService = listingService;
//    }
//
//    @GetMapping("/{mlsid}")
//    public Optional<Listing> getListing(@PathVariable int mlsid){
//        return listingService.getListing(mlsid);
//    }
//    @GetMapping
//    public List<Listing> getListings(){
//
//        return listingService.getListings();
//    }
//
//
//    //RequestBody annotation takes the Listing object as a request payload to the addNewListing POST endpoint
//
//    @PostMapping
//    public void addNewListing(@RequestBody Listing listing){
//        listingService.addListing(listing);
//    }
//
//    @DeleteMapping(path="/{mlsid}")
//    public void deleteListing(@PathVariable("mlsid") int mlsid){
//        listingService.deleteListing(mlsid);
//    }
//
//    @PutMapping(path="/{mlsid}")
//    public void editListing(
//            @PathVariable("mlsid") int mlsid,@RequestBody Listing listing
////            @RequestParam(required = false) String address,
////            @RequestParam(required = false) Integer price
//            ){
//        try {
//            listingService.updateListing(listing.getMlsid(), listing.getAddress(), listing.getPrice());
//        }
//        catch(NullPointerException e){
//            System.out.println("The price of property is : " + listing.getPrice());
//        }
//    }
//
//}
