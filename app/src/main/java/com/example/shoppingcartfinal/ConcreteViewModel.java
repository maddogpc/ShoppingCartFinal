package com.example.shoppingcartfinal;

import androidx.lifecycle.ViewModel;

public class ConcreteViewModel extends ViewModel {
    private User user;
    public ConcreteViewModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
