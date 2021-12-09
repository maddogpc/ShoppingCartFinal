package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

public class ConcreteViewModel extends ViewModel {
    public User user;
    public ConcreteViewModel() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
