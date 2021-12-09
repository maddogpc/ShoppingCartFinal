package com.example.shoppingcartfinal;

/**
 * This an interface for the Concrete ProductBuilder class
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public interface ProductBuilder {
    /**
     * Setter for the name of product
     * @param name
     * @return Class context
     */
    ProductBuilder setProductName(String name);

    /**
     * Setter for the cost of product
     * @param cost
     * @return Class context
     */
    ProductBuilder setProductCost(Double cost);

    /**
     * Setter for the description of product
     * @param desc
     * @return Class context
     */
    ProductBuilder setProductDesc(String desc);

    /**
     * Setter for the product's seller name
     * @param sname
     * @return Class context
     */
    ProductBuilder setProductSeller(String sname);
}
