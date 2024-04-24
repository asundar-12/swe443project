package com.example.demo.Seller;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferIdService {
    private final OfferIdRepository offerIdRepository;

    @Autowired
    public OfferIdService(OfferIdRepository offerIdRepository){
        this.offerIdRepository = offerIdRepository;
    }
    public List<OfferId> fetchOfferIds(){return offerIdRepository.findAll();}

    @Transactional
    public void addOfferId(OfferId offerId){
        Optional<OfferId> checkOfferId = offerIdRepository.findById(offerId.getofferid());
        if (checkOfferId.isPresent()) {
            System.out.println("savedListingId is " + offerId);
            throw new IllegalStateException("The buyer has already saved the listing with that ID");
        }
        offerIdRepository.save(offerId);
        System.out.println(offerId);
    }
}
