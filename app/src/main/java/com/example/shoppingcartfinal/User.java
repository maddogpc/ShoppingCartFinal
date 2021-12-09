package com.example.shoppingcartfinal;

/**
 * This class is an abstract representation of the User, which could be a Buyer or Seller
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public abstract class User {
    String name, email;
    boolean isSeller;

    /**
     * Getter for user name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name, used for updating name in Firebase
     * @param name is an updated rendition
     * @precondition name is not null
     * @postcondition name is an updated attribute
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email, used for updating name in Firebase
     * @param email is an updated rendition
     * @precondition email is not null
     * @postcondition name is an updated attribute
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for seller status of the user
     * @return seller status
     */
    public boolean getSellerStatus() { return isSeller; }

    /**
     * Overridable method called by User template method addObject for inserting objects into an attribute depending of the concrete class used
     * @param obj Random object
     * @precondition The object is either an instance of Card or ShippingDetails classes
     * @postcondition The object is assigned to either the card or shipping details attribute of the Buyer class
     */
    public abstract void insert(Object obj);

    /**
     * Find an object based on the string with the name of the class
     * @param desired is either 'Card' or 'ShippingDetails'
     * @return the object as an instance of the class specified by the string
     */
    public abstract Object locate(String desired);
    public abstract int promote(boolean pos);
    public abstract void addAttributes();

    /**
     * Overridable method called by User template setStatus to change the position of the buyer object, which will be replaced by the seller object
     * @param pos Desired position (true for seller status - false for buyer status)
     * @return a binary digit (1 for seller, 0 for buyer)
     */
    public void setStatus(boolean pos) {
        int position = promote(pos);
        if (position == 0)
        {
            isSeller = false;
        }
        else
        {
            isSeller = true;
        }
    }

    /**
     * Template method to call insert method in the Concrete implementation
     * @param obj Random object
     * @precondition The object is either an instance of Card or ShippingDetails classes
     * @postcondition The object is assigned to either the card or shipping details attribute of the Buyer class
     */
    public void addObject(Object obj) {
        insert(obj);
    }

    /**
     * Find an object based on the string with the name of the class
     * @param desired is either 'Card' or 'ShippingDetails'
     * @return the object as an instance of the class specified by the string
     */
    public Object getObject(String desired) {
        return locate(desired);
    }

    /**
     * Constructor of the User supreclass
     * @param name
     * @param email
     */
    User(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.isSeller = false;
    }
}
