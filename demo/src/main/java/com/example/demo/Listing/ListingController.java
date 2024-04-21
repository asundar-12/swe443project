package com.example.demo.Listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//@RestController
@Controller
@RequestMapping(path="api/v1/listing")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("/{mlsid}")
    @ResponseBody public Optional<Listing> getListing(@PathVariable int mlsid){
        return listingService.getListing(mlsid);
    }
    @GetMapping
    @ResponseBody public List<Listing> getListings(){

        return listingService.getListings();
    }


    //RequestBody annotation takes the Listing object as a request payload to the addNewListing POST endpoint

    @PostMapping
    @ResponseBody public void addNewListing(@RequestBody Listing listing){
        listingService.addListing(listing);
    }

    @DeleteMapping(path="/{mlsid}")
    @ResponseBody public void deleteListing(@PathVariable("mlsid") int mlsid){
        listingService.deleteListing(mlsid);
    }

    @PutMapping(path="/{mlsid}")
    @ResponseBody public void editListing(
            @PathVariable("mlsid") int mlsid,@RequestBody Listing listing
//            @RequestParam(required = false) String address,
//            @RequestParam(required = false) Integer price
            ){
        try {
            listingService.updateListing(listing.getMlsid(), listing.getAddress(), listing.getPrice());
        }
        catch(NullPointerException e){
            System.out.println("The price of property is : " + listing.getPrice());
        }
    }

}
