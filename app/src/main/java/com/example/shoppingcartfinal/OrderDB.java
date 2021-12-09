package com.example.shoppingcartfinal;
import java.util.ArrayList;
import java.io.*;
/**
 * This class represents a database that stores all Order objects; this class is a singleton
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class OrderDB {
    ArrayList<Order> orders;
    private static OrderDB instance;

    /**
     * Constructor
     * @throws IOException when no file is found
     * @throws ClassNotFoundException when no orders were found
     */
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

    /**
     * Method that initializes the singleton object
     * @return instance of the class
     */
    public static OrderDB getInstance() {
        if (instance == null) {
            instance = new OrderDB();
        }
        return instance;
    }

    /**
     * Filters products within the order by the seller's email
     * @param sObj intended seller
     * @return filtered list
     */
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
