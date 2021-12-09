package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

/**
 * This class is an extension of the ViewModel class used for the Order objects when navigating between fragments
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class OrderViewModel extends ViewModel {
    Order order;
    OrderViewModel() {

    }

    /**
     * Setter for the Order object
     * @param order
     * @precondition order exists
     * @postcondition order can be accessed on any fragment that calls it
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Getter for the Order object
     * @return Order object
     */
    public Order getOrder() {
        return order;
    }
}
