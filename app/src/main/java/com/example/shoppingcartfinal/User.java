package com.example.shoppingcartfinal;

public abstract class User {
    String firstName, lastName, email;
    boolean isSeller;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract boolean buyerOrSeller();
    public abstract void addAttributes();

    User(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isSeller = false;
    }
}
