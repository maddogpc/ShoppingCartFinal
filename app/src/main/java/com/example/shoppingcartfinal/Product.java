package com.company;

public class Product implements java.io.Serializable {
    String name;
    double cost;
    String description;
    String seller;

    public double getCost() {
        return cost;
    }

    public Product(String name, double cost, String description, String seller) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.seller = seller;
    }
}