package com.example.buyer.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Service
public class SavedListingService {
    private final SavedListingRepository savedListingRepository;
    @Autowired
    public SavedListingService(SavedListingRepository savedListingRepository) {
        this.savedListingRepository = savedListingRepository;
    }


    public List<SavedListing> fetchSavedListings(@RequestParam("savedListingsIds") List<Integer> listingids) {
        return savedListingRepository.findAll();
    }

    public void addSavedListing() {
    }
}
