//package com.example.demoREST.Offer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping(path="api/v1/offer")
//public class OfferRESTController {
//
//    private final OfferService offerService;
//
//    @Autowired
//    public OfferRESTController(OfferService offerService) {
//        this.offerService = offerService;
//    }
//
//    @GetMapping("/{offerid}")
//    public Optional<Offer> getOffer(@PathVariable int offerid) {
//        return offerService.getOffer(offerid);
//    }
//
//    @GetMapping
//    public List<Offer> getOffers() {
//
//        return offerService.getOffers();
//    }
//
//
//    /**
//     * RequestBody annotation takes the Offer object as a request payload to the addNewOffer POST endpoint
//**/
//    @PostMapping
//    public void addNewOffer(@RequestBody Offer offer) {
//        offerService.addOffer(offer);
//    }
//
//    @DeleteMapping(path = "/{offerid}")
//    public void deleteOffer(@PathVariable("offerid") int offerid) {
//        offerService.deleteOffer(offerid);
//    }
//
//    /**
//     * Do this POST MVP
//     */
////    @PutMapping(path = "/{offerid}")
////    public void editOffer(
////            @PathVariable("offerid") int offerid, @RequestBody Offer offer) {
////
////    }
//}
