package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

public class ShoppingCartViewModel extends ViewModel {
    ShoppingCart shoppingCart;
    ShoppingCartViewModel() {

    }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
