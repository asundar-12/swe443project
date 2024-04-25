package com.example.buyer.buyer;


import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table
public class SavedListing {
    @Id
    @SequenceGenerator(
            name = "SavedListingSequence",
            sequenceName = "SavedListingSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SavedListingSequence"
    )
    private Integer listingid;

    public SavedListing() {
    }

    public SavedListing(Integer listingid) {
        this.listingid = listingid;
    }

    public Integer getListingid() {
        return listingid;
    }

    public void setListingid(Integer listingid) {
        this.listingid = listingid;
    }

    @Override
    public String toString() {
        return "SavedListing{" +
                "listingid=" + listingid +
                '}';
    }


}
