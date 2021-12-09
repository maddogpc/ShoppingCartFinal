package com.example.shoppingcartfinal;

import java.util.ArrayList;

public class Order implements java.io.Serializable {
    String buyerName;
    String buyerEmail;
    String sellerEmail;
    Card cardInfo;
    ShippingDetails shippingDetails;
    ArrayList<Product> products;
    double totalCost;

    public double getTotalCostCost() {
        totalCost = 0;
        double costDifferential = 0;
        for (Product prod : products) {
            costDifferential += prod.getCost();
        }
        totalCost += costDifferential;
        return totalCost;
    }

    public Order(String buyerName, String buyerEmail, Card cardInfo, ShippingDetails shippingDetails, ArrayList<Product> products) {
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.cardInfo = cardInfo;
        this.shippingDetails = shippingDetails;
        this.products = products;
        totalCost = 0;
    }
}