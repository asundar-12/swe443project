package com.example.buyer.buyer;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table
public class BuyerAccount {
    @Id
    @SequenceGenerator(
            name = "BuyerAccountSequence",
            sequenceName = "BuyerAccountSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BuyerAccountSequence"
    )
    private Long buyerid;
    private String email;
    private String name;


    public BuyerAccount() {
    }

    public BuyerAccount(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public BuyerAccount(Long buyerid, String email, String name) {
        this.buyerid = buyerid;
        this.email = email;
        this.name = name;
    }

    public Long getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Long buyerid) {
        this.buyerid = buyerid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BuyerAccounts{" +
                "buyerid=" + buyerid +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
