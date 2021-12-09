package com.example.shoppingcartfinal;

public class Card {
    String carNum;
    String expDate;
    String pin;

    public String getExpDate() {
        return expDate;
    }

    public String getPin() {
        return pin;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    String cardHolder;

    public Card(String num, String exp, String pin, String bname) {
        this.carNum = num;
        this.expDate = exp;
        this.pin = pin;
        this.cardHolder = bname;
    }

    public String getCarNum() {
        return this.carNum;
    }
}