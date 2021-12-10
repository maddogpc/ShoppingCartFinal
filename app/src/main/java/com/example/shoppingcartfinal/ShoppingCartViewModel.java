package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

/**
 * This class is an extension of the ViewModel class to save the shopping cart and use it in a different fragment
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ShoppingCartViewModel extends ViewModel {
    ShoppingCart shoppingCart;

    /**
     * Empty Constructor
     */
    public ShoppingCartViewModel() {

    }

    /**
     * Setter for shopping cart object
     * @param shoppingCart
     * @precondition Shopping cart is populated
     * @postcondition Shopping cart can be used in any fragment associated with one Activity
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Getter for shopping cart object
     * @return shopping cart object
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
