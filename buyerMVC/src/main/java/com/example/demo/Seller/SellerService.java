package com.example.demo.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }
    // Method to add an offer ID to the seller's offerIds string
    public void addOfferIdToSeller(int offerId) {
        Seller seller = getFirstSeller(); // Get the first seller from the database
        if (seller == null) {
            // Handle case where no seller is found
            System.out.println("No seller found in the database.");
            return;
        }

        String currentOfferIds = seller.getOfferIds();

        // Append the new offerId to the current offerIds string, separated by comma
        String updatedOfferIds = currentOfferIds.isEmpty()
                ? String.valueOf(offerId)
                : currentOfferIds + "," + offerId;

        // Update the seller's offerIds
        seller.setOfferIds(updatedOfferIds);
        saveSeller(seller);
    }

    // Method to get the first seller from the database
    private Seller getFirstSeller() {
        // Implement your logic to fetch the first seller from the database
        // Here's a simplified example assuming you have a list of sellers
        List<Seller> sellers = getAllSellers();
        if (!sellers.isEmpty()) {
            return sellers.get(0); // Assuming first seller in the list is the one you want
        }
        return null;
    }
}