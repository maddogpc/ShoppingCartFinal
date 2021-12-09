package com.example.shoppingcartfinal;
import java.util.ArrayList;
import java.io.*;
public class OrderDB {
    ArrayList<Order> orders;
    private static OrderDB instance;
    public OrderDB() {
        try {
            FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"OrderDB");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            orders = (ArrayList<Order>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("orders not found");
            c.printStackTrace();
            return;
        }
    }

    public static OrderDB getInstance() {
        if (instance == null) {
            instance = new OrderDB();
        }
        return instance;
    }

    public ArrayList<Order> getOrdersBySeller(Seller sObj) {
        ArrayList<Order> list = new ArrayList<Order>();
        for (Order ord : orders) {
            if (ord.sellerEmail == sObj.email) {
                list.add(ord);
            }
        }
        return list;
        // raise exception if not found
    }
}
