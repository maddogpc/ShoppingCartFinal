package com.example.shoppingcartfinal;

public class Product implements java.io.Serializable {
    String name;
    double cost;
    String description;
    String seller;

    /**
     * Getter method for the product name
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the product description
     * @return product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method for the seller's name
     * @return seller's name
     */
    public String getSeller() {
        return seller;
    }

    /**
     * Getter method for the cost of product
     * @return cost of product
     */
    public double getCost() {
        return cost;
    }

    /**
     * Constructor method for the Product
     * @param builder object
     */
    public Product(ConcreteProductBuilder builder) {
        this.name = builder.name;
        this.cost = builder.cost;
        this.description = builder.desc;
        this.seller = builder.sname;
    }
}