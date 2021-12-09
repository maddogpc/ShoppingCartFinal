package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

/**
 * This class is an extension of the ViewModel class used for the User object when navigating between fragments
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ConcreteViewModel extends ViewModel {
    public User user;

    /**
     * empty constructor
     */
    public ConcreteViewModel() {

    }

    /**
     * Setter for the User object
     * @return User object
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for the User object
     * @param user
     * @precondition user is not null
     * @postcondition user is either an instance of Buyer or Seller class; it can be accessed by any fragment that calls it
     */
    public void setUser(User user) {
        this.user = user;
    }
}
