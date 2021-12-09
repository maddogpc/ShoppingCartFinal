package com.example.shoppingcartfinal;

import android.widget.Toast;

public class Seller extends User {
    String name, email;
    int positionNo;

    Seller(String name, String email) {

        super(name, email);
        setStatus(true);
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public void insert(Object obj) {

    }

    @Override
    public Object locate(String desired) {
        return null;
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
