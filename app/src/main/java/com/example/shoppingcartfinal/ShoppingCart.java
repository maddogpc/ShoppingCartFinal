package com.example.shoppingcartfinal;
import java.util.ArrayList;

/**
 * This class is a singleton that represents the shopping cart
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ShoppingCart {
    private static ShoppingCart instance;
    ArrayList<Product> products;

    /**
     * Constructor initializes array list of products
     */
    public ShoppingCart() {
        products = new ArrayList<Product>();
        //hard code all the products
        //products.add(new Product("first", 54.42, "first product", "george@fau.edu"));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Add product to shopping cart
     * @param p Product
     * @precondition product is not null
     * @postcondition product is in the shopping cart
     */
    public void addToShoppingCart(Product p) {
        products.add(p);
        // raise exception
    }

    /**
     * Remove product from shopping cart
     * @param p Product in shopping cart
     * @precondition product is in shopping cart
     * @postcondition array list is rebuilt with the removal of specific product
     */
    public void removeFromShoppingCart(Product p) {
        for (Product prod : products) {
            if (p.name == prod.name) {
                products.remove(prod);
            }
        }
        // raise exception
    }

    /**
     * Instance getter
     * @return instance of class
     */
    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
            return instance;
        }
        return instance;
    }
}
