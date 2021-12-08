package com.example.shoppingcartfinal;

public class Buyer extends User {
    String name, email;
    int positionNo;

    public Buyer(String name, String email) {
        super(name, email);
        this.positionNo = 0;
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
