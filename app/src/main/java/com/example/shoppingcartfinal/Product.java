package com.example.shoppingcartfinal;

public class Product implements java.io.Serializable {
    String name;
    double cost;
    String description;
    String seller;

    public double getCost() {
        return cost;
    }

    public Product(ConcreteProductBuilder builder) {
        this.name = builder.name;
        this.cost = builder.cost;
        this.description = builder.desc;
        this.seller = builder.sname;
    }
}