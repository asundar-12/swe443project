package com.example.buyer.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SavedListingService {
    private final SavedListingRepository savedListingRepository;
    @Autowired
    public SavedListingService(SavedListingRepository savedListingRepository) {
        this.savedListingRepository = savedListingRepository;
    }


    public Optional<SavedListing> getSavedListingId(int id) {
        return savedListingRepository.findById(id);
    }

    public List<SavedListing> getSavedListingIds() {
        return savedListingRepository.findAll();
    }

    public void addSavedListingId(SavedListing savedListingId) {
        this.savedListingRepository.save(savedListingId);
    }

    public void deleteSavedListingId(int id) {
        this.savedListingRepository.deleteById(id);
    }
}
