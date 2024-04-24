package com.example.demo.Seller;

import jakarta.persistence.*;

@Entity
@Table
public class OfferId {
    @Id

    private int offerid;

    public OfferId() {
    }

    public OfferId(int offerid) {
        this.offerid = offerid;
    }

    public int getofferid() {
        return offerid;
    }

    public void setofferid(int offerid) {
        this.offerid = offerid;
    }

    @Override
    public String toString() {
        return "offerIds{" +
                "offerid=" + offerid +
                '}';
    }
}
