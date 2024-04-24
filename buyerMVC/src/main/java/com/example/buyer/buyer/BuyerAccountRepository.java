package com.example.buyer.buyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerAccountRepository extends JpaRepository<BuyerAccount,Long> {
}
