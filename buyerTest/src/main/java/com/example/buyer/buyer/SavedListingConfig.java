package com.example.buyer.buyer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SavedListingConfig {
    @Bean
    CommandLineRunner commandLineRunner2 (SavedListingIdsRepository repository){
        return args -> {
                SavedListingIds id1 = new SavedListingIds(15);
            SavedListingIds id2 = new SavedListingIds(14);
            SavedListingIds id3 = new SavedListingIds(12);
            repository.saveAll(List.of(id1, id2, id3));
        };
    }
}
