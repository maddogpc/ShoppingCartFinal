package com.example.shoppingcartfinal;

public class Buyer extends User {
    String firstName, lastName, email;
    int positionNo;
    public Buyer(String firstName, String lastName, String email, int positionNo)
    {
        super(firstName, lastName, email);
        this.positionNo = positionNo;
    }
    @Override
    public void addAttributes() {
        if (positionNo == 0)
        {
            return false;
        }
        else
            return true;
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
