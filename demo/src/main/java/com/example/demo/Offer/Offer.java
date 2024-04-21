package com.example.demo.Offer;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table
public class Offer {
    private int offerid;

    @Override
    public String toString() {
        return "Offer{" +
                "offerid=" + offerid +
                ", negotiatedPrice=" + negotiatedPrice +
                ", mlsid=" + mlsid +
                ", buyerid=" + buyerid +
                ", sellerid=" + sellerid +
                ", offerDate=" + offerDate +
                ", approvedOrRejectSellerStatus='" + approvedOrRejectSellerStatus + '\'' +
                ", notRespondedYet=" + notRespondedYet +
                ", approvedOrRejectUpdatedDate=" + approvedOrRejectUpdatedDate +
                '}';
    }

    @Id
    @SequenceGenerator(
            name="listing_sequence",
            sequenceName="listing_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="listing_sequence"
    )
    public int getOfferid() {
        return offerid;
    }

    public Offer() {
    }

    public Offer(int offerid, Double negotiatedPrice, int mlsid, int buyerid, int sellerid) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        this.offerid = offerid;
        this.negotiatedPrice = negotiatedPrice;
        this.mlsid = mlsid;
        this.buyerid = buyerid;
        this.sellerid = sellerid;
        this.offerDate = new Date();
        this.approvedOrRejectSellerStatus = "Pending";
        this.notRespondedYet = true;
        this.approvedOrRejectUpdatedDate = null;
    }

    public Offer(Double negotiatedPrice, int mlsid, int buyerid, int sellerid) {

        this.negotiatedPrice = negotiatedPrice;
        this.mlsid = mlsid;
        this.buyerid = buyerid;
        this.sellerid = sellerid;
        this.offerDate = new Date();
        this.approvedOrRejectSellerStatus = "Pending";
        this.notRespondedYet = true;
        this.approvedOrRejectUpdatedDate = null;
    }

    public void setOfferid(int offerid) {
        this.offerid = offerid;
    }

    public Double getNegotiatedPrice() {
        return negotiatedPrice;
    }

    public void setNegotiatedPrice(Double negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
    }

    public int getMlsid() {
        return mlsid;
    }

    public void setMlsid(int mlsid) {
        this.mlsid = mlsid;
    }

    public int getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(int buyerid) {
        this.buyerid = buyerid;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public String getApprovedOrRejectSellerStatus() {
        return approvedOrRejectSellerStatus;
    }

    public void setApprovedOrRejectSellerStatus(String approvedOrRejectSellerStatus) {
        this.approvedOrRejectSellerStatus = approvedOrRejectSellerStatus;
    }

    public boolean isNotRespondedYet() {
        return notRespondedYet;
    }

    public void setNotRespondedYet(boolean notRespondedYet) {
        this.notRespondedYet = notRespondedYet;
    }

    public Timestamp getApprovedOrRejectUpdatedDate() {
        return approvedOrRejectUpdatedDate;
    }

    public void setApprovedOrRejectUpdatedDate(Timestamp approvedOrRejectUpdatedDate) {
        this.approvedOrRejectUpdatedDate = approvedOrRejectUpdatedDate;
    }

    private Double negotiatedPrice;
    private int mlsid; // Foreign key referencing the Listing table
    private int buyerid; // Foreign key referencing the buyer's ID (may not enforce FK constraint)
    private int sellerid; // Foreign key referencing the seller's ID (may not enforce FK constraint)
    private Date offerDate;
    private String approvedOrRejectSellerStatus;
    private boolean notRespondedYet;
    private Timestamp approvedOrRejectUpdatedDate;

    // Constructors, getters, and setters
}
