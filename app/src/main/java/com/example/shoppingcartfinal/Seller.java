package com.example.shoppingcartfinal;

import android.widget.Toast;

public class Seller extends User {
    String name, email;
    int positionNo;

    Seller(String name, String email) {

        super(name, email);
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public int promote(boolean pos) {
        if (pos == true)
        {
            this.positionNo = 1;
        }
        else
        {
            this.positionNo = 0;
        }
        return positionNo;
    }
}
