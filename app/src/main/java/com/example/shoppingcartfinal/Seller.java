package com.example.shoppingcartfinal;

public class Seller extends User {
    String firstName, lastName, email;

    Seller(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public boolean buyerOrSeller() {
        return false;
    }
}
