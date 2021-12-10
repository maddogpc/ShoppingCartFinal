package com.example.shoppingcartfinal;

public class ShippingDetails {
    String address;
    String city;
    String region;
    String country;
    String zip;

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

    public String getZip() {
        return zip;
    }

    public ShippingDetails(String address, String city, String region, String country, String zip) {
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zip = zip;
    }
}
