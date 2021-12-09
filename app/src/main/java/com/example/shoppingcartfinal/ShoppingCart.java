package com.example.shoppingcartfinal;
import java.util.ArrayList;

public class ShoppingCart {
    private static ShoppingCart instance;
    ArrayList<Product> products;
    public ShoppingCart() {
        products = new ArrayList<Product>();
        //hard code all the products
        //products.add(new Product("first", 54.42, "first product", "george@fau.edu"));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addToShoppingCart(Product p) {
        products.add(p);
        // raise exception
    }

    public void removeFromShoppingCart(Product p) {
        for (Product prod : products) {
            if (p.name == prod.name) {
                products.remove(prod);
            }
        }
        // raise exception
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
            return instance;
        }
        return instance;
    }
}
