package com.example.shoppingcartfinal;

public class ShippingDetails {
    String address;
    String city;
    String region;
    String country;
    Integer zip;

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public Integer getZip() {
        return zip;
    }

    public ShippingDetails(String address, String city, String region, String country, Integer zip) {
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zip = zip;
    }
}
