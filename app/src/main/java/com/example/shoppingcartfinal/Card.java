package com.example.shoppingcartfinal;

/**
 * This class represents the Card information of the buyer
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class Card {
    String carNum;
    String expDate;
    String pin;

    /**
     * Getter method for card expiration date
     * @return expiration date
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * Getter method for card PIN
     * @return PIN
     */
    public String getPin() {
        return pin;
    }

    /**
     * Getter method for card holder
     * @return card holder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    String cardHolder;

    /**
     * Constructor for Card class
     * @param num card number
     * @param exp card expiration date
     * @param pin card PIN
     * @param bname card holder
     */
    public Card(String num, String exp, String pin, String bname) {
        this.carNum = num;
        this.expDate = exp;
        this.pin = pin;
        this.cardHolder = bname;
    }

    /**
     * Getter method for the card number
     * @return card number
     */
    public String getCarNum() {
        return this.carNum;
    }
}