package com.example.demo.Seller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfferIdService {
    private final OfferIdRepository offerIdRepository;
    @Autowired
    public OfferIdService(OfferIdRepository offerIdRepository) {
        this.offerIdRepository = offerIdRepository;
    }


    public List<OfferId> fetchSavedListings() {
        return offerIdRepository.findAll();
    }

    @Transactional
    public void addSavedListingId(OfferId offerId) {
        Optional<OfferId> checkId = offerIdRepository.findById(offerId.getofferid());
        if (checkId.isPresent()) {
            System.out.println("savedListingId is " + offerId);
            throw new IllegalStateException("The buyer has already saved the listing with that ID");
        }
        offerIdRepository.save(offerId);
        System.out.println(offerId);
    }
}
