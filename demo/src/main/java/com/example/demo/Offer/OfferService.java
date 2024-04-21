package com.example.demo.Offer;

import com.example.demo.Listing.Listing;
import com.example.demo.Offer.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Optional<Offer> getOffer(int offerid) {
//        System.out.println(STR."Offerid is: \{offerid}");
        return offerRepository.findById(offerid);
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }
    @Transactional
    public void addOffer(Offer offer) {
        Optional<Offer> checkOffer = offerRepository.findByMlsid(offer.getMlsid());
        if (checkOffer.isPresent()) {
            System.out.println("MLSID is " + offer.getMlsid());
            throw new IllegalStateException("A Offer has already been made for the property with that MlsID");
        }
        offerRepository.save(offer);
        System.out.println(offer);
    }

    @Transactional
    public void deleteOffer(int offerid) {
        boolean checkOfferExists = offerRepository.existsById(offerid);
        if (!checkOfferExists) {
            throw new IllegalStateException();
        }
        offerRepository.deleteById(offerid);
    }

    @Transactional
    public void updateOfferStatus(int offerid, String approvedOrRejectSellerStatus) {
        Offer offer = offerRepository.findById(offerid).orElseThrow(()-> new IllegalStateException("offer with THAT offerid does not exist"));
        offer.setNotRespondedYet(false);
        offer.setApprovedOrRejectSellerStatus(approvedOrRejectSellerStatus);
        offer.setApprovedOrRejectUpdatedDate(new Timestamp(System.currentTimeMillis()));
        offerRepository.save(offer);
    }
}

/**
 * POST MVP
 */
//    @Transactional
//    public void updateListing(int mlsid, String newAddress, int newPrice) {


