package com.example.buyer.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BuyerAccountService {
    private final BuyerAccountRepository buyerAccountRepository;

    @Autowired
    public BuyerAccountService(BuyerAccountRepository buyerAccountRepository) {
        this.buyerAccountRepository = buyerAccountRepository;
    }

    public List<BuyerAccount> getAccount(){
        return buyerAccountRepository.findAll();
    }

    public BuyerAccount getBuyerAccountById(Long id) {
        return buyerAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BuyerAccount not found"));
    }

    public BuyerAccount saveBuyerAccount(BuyerAccount buyerAccount) {
        return buyerAccountRepository.save(buyerAccount);
    }

    public void deleteBuyerAccountById(Long id) {
        buyerAccountRepository.deleteById(id);
    }
}
