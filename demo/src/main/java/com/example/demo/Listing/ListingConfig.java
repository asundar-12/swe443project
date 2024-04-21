package com.example.demo.Listing;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class ListingConfig {

    @Bean
    CommandLineRunner commandLineRunner(ListingRepository repository){
        return args -> {
//            Listing property1 = new Listing(
//                    "House",
//                    3,
//                    2,
//                    123,
//                    250000,
//                    "123 Main St",
//                    "05/10/2000"
//            );
//            Listing property2 = new Listing(
//                    "Apartment",
//                    2,
//                    1,
//                    789012,
//                    180000,
//                    "456 Elm St",
//                    "08/21/2000"
//            );
//
//            Listing property3 = new Listing(
//                    "Condo",
//                    1,
//                    1,
//                    345678,
//                    120000,
//                    "789 Oak St",
//                    "11/04/2000"
//            );
//
//            Listing property4 = new Listing(
//                    "House",
//                    4,
//                    3,
//                    901234,
//                    350000,
//                    "567 Pine St",
//                    "09/30/2000"
//            );
//
//            Listing property5 = new Listing(
//                    "Apartment",
//                    1,
//                    1,
//                    567890,
//                    100000,
//                    "890 Maple St",
//                    "12/12/2000"
//            );
//
//            Listing property6 = new Listing(
//                    "Condo",
//                    3,
//                    2,
//                    234567,
//                    250000,
//                    "123 Elm St",
//                    "07/28/2000"
//            );
//
//            Listing property7 = new Listing(
//                    "House",
//                    5,
//                    4,
//                    890123,
//                    400000,
//                    "456 Oak St",
//                    "10/09/2000"
//            );
//
//            Listing property8 = new Listing(
//                    "Apartment",
//                    2,
//                    2,
//                    456789,
//                    180000,
//                    "789 Cedar St",
//                    "07/05/2000"
//            );
//
//            Listing property9 = new Listing(
//                    "Condo",
//                    1,
//                    1,
//                    123890,
//                    140000,
//                    "890 Elmwood St",
//                    "10/18/2000"
//            );
//
//            Listing property10 = new Listing(
//                    "House",
//                    4,
//                    3,
//                    678901,
//                    360000,
//                    "567 Pinehurst St",
//                    "11/26/2000"
//            );
//
//
//            repository.saveAll(
//                    List.of(property1,
//                            property2,
//                            property3,
//                            property4,
//                            property5,
//                            property6,
//                            property7,
//                            property8,
//                            property9,
//                            property10
//
//                    )
//            );


        };
    }
}
