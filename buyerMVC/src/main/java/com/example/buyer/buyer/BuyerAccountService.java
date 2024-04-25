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

    public List<BuyerAccount> getAccount(int id){
        return buyerAccountRepository.findById(id);
    }

    public List<BuyerAccount> getAccounts() {
        return buyerAccountRepository.findAll();
    }

    public void addNewAccount(BuyerAccount account) {
        return buyerAccountRepository.save(account);
    }

    public void deleteAccount(int id) {
        return buyerAccountRepository.deleteById(id);
    }
}
