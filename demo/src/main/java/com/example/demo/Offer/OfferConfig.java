package com.example.demo.Offer;

import com.example.demo.Listing.ListingRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration

public class OfferConfig {

    @Bean
    CommandLineRunner offersRunner(OfferRepository repository) {

        return args -> {
//            Offer offer1 = new Offer(240000.0, 1, 1001, 2001, new Date(2023, 6, 1), null, true, null);
//            Offer offer2 = new Offer(180000.0, 2, 1002, 2002, new Date(2023-1900, 8, 15), null, true, null);
//            Offer offer3 = new Offer(130000.0, 3, 1003, 2003, new Date(2023-1900, 11, 1), null, true, null);
//            Offer offer4 = new Offer(320000.0, 4, 1004, 2004, new Date(2023-1900, 9, 20), null, true, null);
//            Offer offer5 = new Offer(150000.0, 5, 1005, 2005, new Date(2023-1900, 11, 20), null, true, null);
//            Offer offer6 = new Offer(220000.0, 6, 1006, 2006, new Date(2023-1900, 7, 15), null, true, null);
//            Offer offer7 = new Offer(390000.0, 7, 1007, 2007, new Date(2023-1900, 10, 1), null, true, null);
//            Offer offer8 = new Offer(200000.0, 8, 1008, 2008, new Date(2023-1900, 7, 1), null, true, null);
//            Offer offer9 = new Offer(140000.0, 9, 1009, 2009, new Date(2023-1900, 10, 5), null, true, null);
//            Offer offer10 = new Offer(350000.0, 10, 1010, 2010, new Date(2023-1900, 11, 15), null, true, null);
//
//            repository.saveAll(List.of(offer1, offer2, offer3, offer4, offer5, offer6, offer7, offer8, offer9, offer10));
        };
    }
}