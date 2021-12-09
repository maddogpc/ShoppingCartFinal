package com.example.shoppingcartfinal;

public abstract class User {
    String name, email;
    boolean isSeller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getSellerStatus() { return isSeller; }

    public abstract void insert(Object obj);
    public abstract Object locate(String desired);
    public abstract int promote(boolean pos);
    public abstract void addAttributes();

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

    public void addObject(Object obj) {
        insert(obj);
    }

    public Object getObject(String desired) {
        return locate(desired);
    }

    User(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.isSeller = false;
    }
}
