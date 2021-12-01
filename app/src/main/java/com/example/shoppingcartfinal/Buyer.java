package com.example.shoppingcartfinal;

public class Buyer extends User {
    String name, email;
    int positionNo;

    public Buyer(String name, String email, int positionNo) {
        super(name, email);
        this.positionNo = positionNo;
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public boolean buyerOrSeller() {
        if (positionNo == 0)
        {
            return false;
        }
        else
            return true;
    }

}
