package com.example.demo.Listing;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<Listing> getListings(){
//        System.out.println(STR."Here is the data: \{listingRepository.findAll()}");
       return listingRepository.findAll();
    }

    public Optional<Listing> getListing(int mlsid){
//        System.out.println(STR."Mlsid is: \{mlsid}");
        return listingRepository.findById(mlsid);
    }

    @Transactional
    public void addListing(Listing listing) {
        Optional<Listing> checkListing = listingRepository.findListingByAddress(listing.getAddress());
        if(checkListing.isPresent()){
            throw new IllegalStateException("A Listing with that Street Address has already been created");
        }
        listingRepository.save(listing);
        System.out.println(listing);
    }

    @Transactional
    public void deleteListing(int mlsid) {
        boolean checkListingExists = listingRepository.existsById(mlsid);
        if(!checkListingExists){
            throw new IllegalStateException("listing with THAT mlsid does not exist");
        }
        listingRepository.deleteById(mlsid);
    }

    @Transactional
    public void updateListing(int mlsid, String newAddress, int newPrice) {
        boolean checkListingExists = listingRepository.existsById(mlsid);
        Listing listing = listingRepository.findById(mlsid).orElseThrow(()-> new IllegalStateException("listing with THAT mlsid does not exist"));
        if(newAddress!=null && !newAddress.isEmpty() && !newAddress.equals(listing.getAddress())){
            Optional<Listing> maybeListing = listingRepository.findListingByAddress(newAddress);
            if(maybeListing.isPresent()){
                throw new IllegalStateException("listing with that same street address already exists.");
            }
            else{
                listing.setAddress(newAddress);
            }
        }
        if(newPrice>=10000 ){
            listing.setPrice(newPrice);
        }
        else{
            throw new IllegalStateException("Error in updating price of current listing");
        }
    }
}
