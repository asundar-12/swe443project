package com.example.demo.Seller;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "offer_ids", length = 1000)
    private String offerIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfferIds() {
        return offerIds;
    }

    public void setOfferIds(String offerIds) {
        this.offerIds = offerIds;
    }
}
