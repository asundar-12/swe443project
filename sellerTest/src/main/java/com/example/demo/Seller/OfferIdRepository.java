package com.example.demo.Seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferIdRepository extends JpaRepository<OfferId, Integer> {

}
