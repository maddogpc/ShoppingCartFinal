package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {
    Product product;
    ProductViewModel() {

    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }
}
