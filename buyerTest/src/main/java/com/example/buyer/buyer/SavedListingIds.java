package com.example.buyer.buyer;


import jakarta.persistence.*;

@Entity
@Table
public class SavedListingIds {
    @Id
//    @SequenceGenerator(
//            name = "SavedListingSequence",
//            sequenceName = "SavedListingSequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "SavedListingSequence"
//    )
    private int listingid;

    public SavedListingIds() {
    }

    public SavedListingIds(int listingid) {
        this.listingid = listingid;
    }

    public int getListingid() {
        return listingid;
    }

    public void setListingid(int listingid) {
        this.listingid = listingid;
    }

    @Override
    public String toString() {
        return "SavedListingIds{" +
                "listingid=" + listingid +
                '}';
    }
}
