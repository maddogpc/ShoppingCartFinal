package com.example.shoppingcartfinal;

import java.util.ArrayList;

public class Buyer extends User {
    String name, email;
    //ArrayList<Card> cards;
    //ArrayList<ShippingDetails> sd;
    Card card;
    ShippingDetails shippingDetails;
    int positionNo;

    public Buyer(String name, String email) {
        super(name, email);
        this.positionNo = 0;
        this.card = null;
        this.shippingDetails = null;
        //this.card = new ArrayList<>();
        //this.sd = new ArrayList<>();
    }

    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    @Override
    public void insert(Object obj) {
        if (obj instanceof Card)
        {
            //this.cards.add((Card) obj);
            this.card = (Card) obj;
        }
        else if (obj instanceof ShippingDetails)
        {
            //this.sd.add((ShippingDetails) obj);
            this.shippingDetails = (ShippingDetails) obj;
        }
        else
        {
            System.out.println("Not a desirable object");
        }
    }

    @Override
    public Object locate(String desired) {

        //if (desired == "Cards" && !cards.isEmpty())
        if (desired == "Card" && card != null)
        {
            //return cards;
            return card;
        }
        //else if (desired == "ShippingDetails" && !sd.isEmpty())
        else if (desired == "ShippingDetails" && card != null)
        {
            //return sd;
            return shippingDetails;
        }
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
