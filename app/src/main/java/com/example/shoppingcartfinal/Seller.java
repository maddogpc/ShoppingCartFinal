package com.example.shoppingcartfinal;

/**
 * This class is represents the Seller as an extension of the User abstract class
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class Seller extends User {
    String name, email;
    int positionNo;

    /**
     * Constructor
     * @param name of seller
     * @param email of seller
     */
    Seller(String name, String email) {

        super(name, email);
        setStatus(true);
    }

    /**
     * Overridable method
     */
    @Override
    public void addAttributes() {
        System.out.println("test");
    }

    /**
     * Method only used by the Buyer class
     * @param obj
     */
    @Override
    public void insert(Object obj) {

    }

    /**
     * Method only used by the Buyer class
     * @param desired
     * @return
     */
    @Override
    public Object locate(String desired) {
        return null;
    }

    /**
     * Promote, generally used by the buyer class; can also be used on the seller class to demote back to buyer
     * @param pos Position of user (true for seller - false for buyer)
     * @return 1 for seller - 0 for buyer
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
