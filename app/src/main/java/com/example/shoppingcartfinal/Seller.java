package com.example.shoppingcartfinal;

public class Seller extends User {
    String name, email;
    int positionNo;

    Seller(String name, String email, int positionNo) {

        super(name, email);
        this.positionNo = positionNo;
        isBuyerOrSeller();
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public boolean buyerOrSeller() {
        if (positionNo == 1)
            return true;
        else
            return false;
    }
}
