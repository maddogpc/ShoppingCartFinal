package com.example.shoppingcartfinal;

import java.util.ArrayList;

/**
 * This class represents the order placed by the buyer
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class Order implements java.io.Serializable {
    String buyerName;
    String buyerEmail;
    String sellerEmail;
    Card cardInfo;
    ShippingDetails shippingDetails;

    /**
     * Getter method for the buyer's name
     * @return buyer name
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Getter method for the buyer's email
     * @return
     */
    public String getBuyerEmail() {
        return buyerEmail;
    }

    /**
     * Getter method for the buyer's card
     * @return card information
     */
    public Card getCardInfo() {
        return cardInfo;
    }

    /**
     * Getter method for the buyer's shipping details
     * @return shipping details
     */
    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    /**
     * Getter method for the purchased products
     * @return purchased product list
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Gets all products by a particular seller
     * @param seller
     * @return List of products sharing one seller
     */
    public ArrayList<Product> getProductsBySellerName(User seller) {
        ArrayList<Product> products = new ArrayList<>();
        if (seller instanceof Seller) {
            for (Product product : getProducts()) {
                if (product.getSeller().equals(seller.getName())) {
                    products.add(product);
                }
            }
            return products;
        }
        return null;
    }

    public double getTotalCost() {
        return totalCost;
    }

    ArrayList<Product> products;
    double totalCost;

    /**
     * Method that sums all the cost of purchased products
     * @return sum of all purchased products
     */
    public double getTotalCostCost() {
        totalCost = 0;
        double costDifferential = 0;
        for (Product prod : products) {
            costDifferential += prod.getCost();
        }
        totalCost += costDifferential;
        return totalCost;
    }

    /**
     * Constructor for the Order class
     * @param buyerName
     * @param buyerEmail
     * @param cardInfo
     * @param shippingDetails
     * @param products
     */
    public Order(String buyerName, String buyerEmail, Card cardInfo, ShippingDetails shippingDetails, ArrayList<Product> products) {
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.cardInfo = cardInfo;
        this.shippingDetails = shippingDetails;
        this.products = products;
        totalCost = 0;
    }
}