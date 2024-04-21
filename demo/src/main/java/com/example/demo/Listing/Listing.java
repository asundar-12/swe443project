package com.example.demo.Listing;

import jakarta.persistence.*;

@Entity
@Table
public class Listing {
    private String type;
    private int beds;
    private int baths;
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
    private int mlsid;

    public String getListeddate() {
        return listeddate;
    }

    public void setListeddate(String listeddate) {
        this.listeddate = listeddate;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "type='" + type + '\'' +
                ", beds=" + beds +
                ", baths=" + baths +
                ", mlsid=" + mlsid +
                ", price=" + price +
                ", address='" + address + ", listeddate='" + listeddate + '\'' +
                '}';
    }

    public Listing() {
    }

    public Listing(String type, int beds, int baths, int price, String address, String listeddate) {
        this.type = type;
        this.beds = beds;
        this.baths = baths;
        this.price = price;
        this.address = address;
        this.listeddate = listeddate;

    }

    public Listing(String type, int beds, int baths, int mlsid, int price, String address, String listeddate) {
        this.type = type;
        this.beds = beds;
        this.baths = baths;
        this.mlsid = mlsid;
        this.price = price;
        this.address = address;
        this.listeddate = listeddate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getMlsid() {
        return mlsid;
    }

    public void setMlsid(int mlsid) {
        this.mlsid = mlsid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int price;
    private String address;

    private String listeddate;
}
