package com.example.shoppingcartfinal;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * This class represents a database that stores all Order objects; this class is a singleton
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class OrderDB {
    ArrayList<Order> orders;
    private static OrderDB instance;
    Context context;

    /**
     * Constructor
     * @throws IOException when no file is found
     * @throws ClassNotFoundException when no orders were found
     */
    public OrderDB(Context con) {
        this.context = con;
        boolean ioExcept = false;
        try {
            System.out.println("/storage/self/primary/Android/data/com.example.shoppingcartfinal/files/ProductDB");
            FileInputStream fileIn = new FileInputStream("/storage/self/primary/Android/data/com.example.shoppingcartfinal/files/ProductDB");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            orders = (ArrayList<Order>) in.readObject();
//            for (Order ord : orders) {
//                System.out.println(ord.buyerEmail);
//            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("IO Exception");
            i.printStackTrace();
            ioExcept = true;
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("orders not found");
            c.printStackTrace();
            return;
        }
        finally {
            if (ioExcept) {
                saveDB(true);
            }
        }
    }

    /**
     * Another constructor using VarArgs
     * @param con Context of the Activity associated with the current fragment
     * @param ords VarArgs that inserts multiple products
     */
    public OrderDB(Context con, Order ... ords) {
        this.context = con;
        orders = new ArrayList<Order>();
        for (Order ord : ords) {
            addOrder(ord);
        }
    }

    /**
     * Save the updated database to a file
     * @param clearDataBase determines whether it requires to delete all objects before saving or not
     * @precondition Database is updated or has objects
     * @postcondition Database is populated upon saving
     */
    public void saveDB (boolean clearDataBase) {
        ArrayList<Order> OrderListObj;
        if (clearDataBase) {
            OrderDB ODB = new OrderDB(context);
            OrderListObj = ODB.orders;
        }
        else {
            OrderListObj = orders;
        }

        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }

        File file = new File(context.getExternalFilesDir(null), "OrderDB");
        System.out.println("context.getExternalFilesDir(null)");
        System.out.println(context.getExternalFilesDir(null));
        FileOutputStream outputStream = null;
        try {
            System.out.println("file.listFiles()");
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);

            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(OrderListObj);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            System.out.println("Unable to write");
            e.printStackTrace();
        }
    }

    /**
     * Method that initializes the singleton object
     * @param con Context of the Activity associated with current fragment
     * @return instance of the class
     */
    public static OrderDB getInstance(Context con) {
        if (instance == null) {
            instance = new OrderDB(con);
        }
        return instance;
    }

    /**
     * Adds the product to the database
     * @param newOrd product to be added
     * @precondition newProd is not null
     * @postcondition newProd populates the database
     */
    public void addOrder(Order newOrd) {
        orders.add(newOrd);
        saveDB(false);
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
