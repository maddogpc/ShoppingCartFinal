package com.example.shoppingcartfinal;

/**
 * This class is a builder for the Product class implementing the product builder interface
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ConcreteProductBuilder implements ProductBuilder {

    String name, desc, sname;
    Double cost;

    /**
     * Setter for the name of product
     * @param name of product
     * @return context of the class
     */
    @Override
    public ConcreteProductBuilder setProductName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Setter for the product cost
     * @param cost of product
     * @return context of the class
     */
    @Override
    public ConcreteProductBuilder setProductCost(Double cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Setter for the product description
     * @param desc of product
     * @return context of the class
     */
    @Override
    public ConcreteProductBuilder setProductDesc(String desc) {
        this.desc = desc;
        return this;
    }

    /**
     * Setter for the name of the seller
     * @param sname
     * @return context of the class
     */
    @Override
    public ConcreteProductBuilder setProductSeller(String sname) {
        this.sname = sname;
        return this;
    }
}
