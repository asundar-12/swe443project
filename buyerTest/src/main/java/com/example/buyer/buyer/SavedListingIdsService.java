package com.example.buyer.buyer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class SavedListingIdsService {
    private final SavedListingIdsRepository savedListingIdsRepository;
    @Autowired
    public SavedListingIdsService(SavedListingIdsRepository savedListingIdsRepository) {
        this.savedListingIdsRepository = savedListingIdsRepository;
    }


    public List<SavedListingIds> fetchSavedListings() {
        return savedListingIdsRepository.findAll();
    }

    @Transactional
    public void addSavedListingId(SavedListingIds savedListingId) {
        Optional<SavedListingIds> checkId = savedListingIdsRepository.findById(savedListingId.getListingid());
        if (checkId.isPresent()) {
            System.out.println("savedListingId is " + savedListingId);
            throw new IllegalStateException("The buyer has already saved the listing with that ID");
        }
        savedListingIdsRepository.save(savedListingId);
        System.out.println(savedListingId);
    }
}
