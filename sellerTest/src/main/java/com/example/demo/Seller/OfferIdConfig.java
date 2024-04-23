package com.example.demo.Seller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OfferIdConfig {
    @Bean
    CommandLineRunner commandLineRunner2 (OfferIdRepository repository){
        return args -> {
            OfferId id1 = new OfferId(15);
            OfferId id2 = new OfferId(14);
            OfferId id3 = new OfferId(12);
            repository.saveAll(List.of(id1, id2, id3));
        };
    }
}
