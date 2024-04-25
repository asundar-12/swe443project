package com.example.buyer.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BuyerController {

    private final BuyerAccountRepository accountRepository;
    private final SavedListingRepository savedListingRepository;

    private final BuyerAccountService buyerAccountService;
    
    private final SavedListingService savedListingService;
    
    public BuyerController(BuyerAccountRepository accountRepository, SavedListingRepository savedListingRepository, BuyerAccountService buyerAccount, SavedListingService savedListing) {
        this.accountRepository = accountRepository;
        this.savedListingRepository = savedListingRepository;
        this.buyerAccountService = buyerAccount;
        this.savedListingService = savedListing;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<BuyerAccount> getAccount(@PathVariable int id){
        return buyerAccountService.getAccount(id);
    }
    @GetMapping
    @ResponseBody public List<BuyerAccount> getListings(){

        return buyerAccountService.getAccounts();
    }


    //RequestBody annotation takes the Listing object as a request payload to the addNewListing POST endpoint

    @PostMapping
    @ResponseBody public void addAccount(@RequestBody BuyerAccount account){
        buyerAccountService.addNewAccount(account);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody public void deleteAccount(@PathVariable("id") int id){
        buyerAccountService.deleteAccount(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<SavedListing> getSavedListingId(@PathVariable int id){
        return savedListingService.getSavedListingId(id);
    }
    @GetMapping
    @ResponseBody public List<SavedListing> getSavedListingIds(){

        return savedListingService.getSavedListingIds();
    }


    //RequestBody annotation takes the Listing object as a request payload to the addNewListing POST endpoint

    @PostMapping
    @ResponseBody public void addSavedListingId(@RequestBody SavedListing savedListingId){
        savedListingService.addSavedListingId(savedListingId);
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody public void deleteSavedListingId(@PathVariable("id") int id){
        savedListingService.deleteSavedListingId(id);
    }

}
