package com.example.shoppingcartfinal;

public class Card {
    String carNum;
    String expDate;
    String pin;
    String cardHolder;

    public Card(String num, String exp, String pin, String bname) {
        this.carNum = num;
        this.expDate = exp;
        this.pin = pin;
        this.cardHolder = bname;
    }
}