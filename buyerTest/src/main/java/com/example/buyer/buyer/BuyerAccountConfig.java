//package com.example.buyer.buyer;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class BuyerAccountConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(BuyerAccountRepository repository){
//        return args -> {
//            BuyerAccount diego = new BuyerAccount("dpena6@gmu.edu","Diego");
//            BuyerAccount santi = new BuyerAccount("spena@gmu.edu","Santi");
//            BuyerAccount andrea = new BuyerAccount("Apena@gmail.com","Andrea");
//            repository.saveAll(List.of(diego,santi,andrea));
//        };
//    }
//}
