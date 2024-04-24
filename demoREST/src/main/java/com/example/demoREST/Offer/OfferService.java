package com.example.demoREST.Offer;

import com.example.demoREST.Listing.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

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
        System.out.println("Offer id is: " + offerid);
        return offerRepository.findById(offerid);
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    @Transactional
    public void addOffer(Offer offer) {
        Optional<Offer> checkOffer = offerRepository.findByMlsid(offer.getMlsid());
        if (checkOffer.isPresent()) {
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
    public void updateOffer(int offerid, String status) {
        boolean checkListingExists = offerRepository.existsById(offerid);
        Offer offer = offerRepository.findById(offerid).orElseThrow(()-> new IllegalStateException("Offer with THAT offerid does not exist"));
        if(status!=null){
            if(offer.getApprovedOrRejectSellerStatus().equals(status)){
                throw new IllegalStateException("Offer has already been approved or rejected");
            }
            else{
                offer.setApprovedOrRejectSellerStatus(status);
                offerRepository.save(offer);
            }
        }
    }

}