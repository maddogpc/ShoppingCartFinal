package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

/**
 * This class is an extension of the ViewModel class used for the Product objects during navigation between fragments
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ProductViewModel extends ViewModel {
    Product product;

    /**
     * Empty constructor
     */
    public ProductViewModel() {

    }

    /**
     * Setter for product
     * @param product
     * @precondition product is not null
     * @postcondition product is in the ViewModel
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter for product
     * @return product
     */
    public Product getProduct() {
        return product;
    }
}
