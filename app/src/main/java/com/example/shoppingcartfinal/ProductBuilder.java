package com.example.shoppingcartfinal;

public interface ProductBuilder {
    ProductBuilder setProductName(String name);
    ProductBuilder setProductCost(Double cost);
    ProductBuilder setProductDesc(String desc);
    ProductBuilder setProductSeller(String sname);
}
