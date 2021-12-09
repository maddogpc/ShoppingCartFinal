package com.example.shoppingcartfinal;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
public class ProductDB {
    ArrayList<Product> products;
    private static ProductDB instance;
    public ProductDB() {
        try {
            FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"ProductDB");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            products = (ArrayList<Product>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("products not found");
            c.printStackTrace();
            return;
        }
    }

    public static ProductDB getInstance() {
        if (instance == null) {
            instance = new ProductDB();
        }
        return instance;
    }

    public Product getProduct(String productName) {
        for (Product prod : products) {
            if (prod.name == productName) {
                return prod;
            }
        }
        return null;
        // raise exception
    }

    public ArrayList<Product> listProductsBySeller(String sellerName) {
        ArrayList<Product> list = new ArrayList<Product>();
        for (Product prod : products) {
            if (prod.seller == sellerName) {
                list.add(prod);
            }
        }
        return list;
        // raise exception if not found
    }
}
