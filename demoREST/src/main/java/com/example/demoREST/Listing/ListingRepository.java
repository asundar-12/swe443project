package com.example.demoREST.Listing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListingRepository
        extends JpaRepository<Listing, Integer> {

//    @Query("SELECT l from Listing l WHERE l.address = ?1")
    Optional<Listing> findListingByAddress(String address);
}
