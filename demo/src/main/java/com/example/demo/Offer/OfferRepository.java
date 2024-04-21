package com.example.demo.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository
        extends JpaRepository<Offer, Integer> {

    @Query("SELECT l from Offer l WHERE l.mlsid = ?1")
    Optional<Offer> findByMlsid(int mlsid);
    @Query("SELECT l from Offer l WHERE l.offerid = ?1")
    Optional<Offer> findByOfferid(int offerid);
}
