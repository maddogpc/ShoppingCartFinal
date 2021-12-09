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
 * This class is represents a Database of product objects read from a file; this is a singleton class
 * @author Franco Carbajal-Cossi, Madison Verger, Jaylen Robinson
 */
public class ProductDB {
    ArrayList<Product> products;
    private static ProductDB instance;
    Context context;

    /**
     * Constructor for the Product Database class
     * @param con Context of the Activity associated with the fragment
     * @throws IOException when no file was found
     * @throws ClassNotFoundException when no products were found
     */
    public ProductDB(Context con) {
        this.context = con;
        boolean ioExcept = false;
        try {
            System.out.println("/storage/self/primary/Android/data/com.example.shoppingcartfinal/files/ProductDB");
            FileInputStream fileIn = new FileInputStream("/storage/self/primary/Android/data/com.example.shoppingcartfinal/files/ProductDB");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            products = (ArrayList<Product>) in.readObject();
            for (Product prod : products) {
                System.out.println(prod.name);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("IO Exception");
            i.printStackTrace();
            ioExcept = true;
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("products not found");
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
     * Adds the product to the database
     * @param newProd product to be added
     * @precondition newProd is not null
     * @postcondition newProd populates the database
     */
    public void addProduct(Product newProd) {
        products.add(newProd);
        saveDB(false);
    }

    /**
     * Another constructor using VarArgs
     * @param con Context of the Activity associated with the current fragment
     * @param prods VarArgs that inserts multiple products
     */
    public ProductDB(Context con, Product ... prods) {
        this.context = con;
        products = new ArrayList<Product>();
        for (Product prod : prods) {
            addProduct(prod);
        }
    }

    /**
     * Save the updated database to a file
     * @param clearDataBase determines whether it requires to delete all objects before saving or not
     * @precondition Database is updated or has objects
     * @postcondition Database is populated upon saving
     */
    public void saveDB (boolean clearDataBase) {
        ArrayList<Product> ProductListObj;
        if (clearDataBase) {
            ProductDB PDB = new ProductDB(context,
                    new Product(new ConcreteProductBuilder().setProductName("name1").setProductCost(5.00).setProductDesc("desc1").setProductSeller("seller1")),
                            new Product(new ConcreteProductBuilder().setProductName("name2").setProductCost(5.00).setProductDesc("desc2").setProductSeller("seller2")),
                                    new Product(new ConcreteProductBuilder().setProductName("name3").setProductCost(5.00).setProductDesc("desc3").setProductSeller("seller3"))
            );
            ProductListObj = PDB.products;
        }
        else {
            ProductListObj = products;
        }

        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }

        File file = new File(context.getExternalFilesDir(null), "ProductDB");
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
            oos.writeObject(ProductListObj);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            System.out.println("Unable to write");
            e.printStackTrace();
        }
    }

    /**
     * Instance getter to initialize singleton class
     * @param con Context of the Activity associated with current fragment
     * @return instance of the class
     */
    public static ProductDB getInstance(Context con) {
        if (instance == null) {
            instance = new ProductDB(con);
        }
        return instance;
    }

    /**
     * Getter for the product by using the product name
     * @param productName
     * @return Product object
     */
    public Product getProduct(String productName) {
        for (Product prod : products) {
            if (prod.name == productName) {
                return prod;
            }
        }
        return null;
    }

    /**
     * Getter for the products list
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
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
