package com.example.buyer.buyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedListingIdsRepository extends JpaRepository<SavedListingIds, Integer> {

//    Optional<SavedListingIds> findListingById(String address);
}
