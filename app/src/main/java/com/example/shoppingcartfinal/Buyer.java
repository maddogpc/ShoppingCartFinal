package com.example.shoppingcartfinal;

/**
 * This class is a concrete instance of the User abstract class
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class Buyer extends User {
    String name, email;
    //ArrayList<Card> cards;
    //ArrayList<ShippingDetails> sd;
    Card card;
    ShippingDetails shippingDetails;
    int positionNo;

    /**
     * Constructor
     * @param name of the buyer
     * @param email of the buyer
     */
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

    /**
     * Overridable method called by User template method addObject for inserting objects into an attribute depending of the concrete class used
     * @param obj Random object
     * @precondition The object is either an instance of Card or ShippingDetails classes
     * @postcondition The object is assigned to either the card or shipping details attribute of the Buyer class
     */
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

    /**
     * Find an object based on the string with the name of the class
     * @param desired is either 'Card' or 'ShippingDetails'
     * @return the object as an instance of the class specified by the string
     */
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

    /**
     * Overridable method called by User template setStatus to change the position of the buyer object, which will be replaced by the seller object
     * @param pos Desired position (true for seller status - false for buyer status)
     * @return a binary digit (1 for seller, 0 for buyer)
     */
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
