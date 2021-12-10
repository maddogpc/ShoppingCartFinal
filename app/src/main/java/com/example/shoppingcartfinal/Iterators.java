package com.example.shoppingcartfinal;

import android.content.Context;

import java.util.ArrayList;

public class Iterators {
    private static ProductIterator pi;
    private static OrderIterator it;
    public static ProductIterator getProductIterator(Context con) {
        if (pi == null) {
            pi = new ProductIterator(ProductDB.getInstance(con).getProducts());
        }
        return pi;
    }
    public static OrderIterator getOrderIterator(Context con) {
        if (it == null) {
            it = new OrderIterator(OrderDB.getInstance(con).getOrders());
        }
        return it;
    }
    public static OrderIterator getOrderIterator(Context con, Seller seller) {
        if (it == null) {
            it = new OrderIterator(OrderDB.getInstance(con).getOrdersBySeller(seller));
        }
        return it;
    }


    interface Iterator
    {
        boolean hasNext();
        Object next();
    }

    public static class ProductIterator implements Iterator
    {
        ArrayList<Product> products;
        int pos = 0;

        public ProductIterator (ArrayList<Product> products)
        {
            this.products = products;
        }

        public Object next()
        {
            Product prod = products.get(pos);
            pos += 1;
            return prod;
        }

        public boolean hasNext()
        {
            if (pos >= products.size() ||
                    products.get(pos) == null)
                return false;
            else
                return true;
        }
    }
    public static class OrderIterator implements Iterator
    {
        ArrayList<Order> orders;
        int pos = 0;

        public OrderIterator (ArrayList<Order> orders)
        {
            this.orders = orders;
        }

        public Object next()
        {
            Order ord = orders.get(pos);
            pos += 1;
            return ord;
        }

        public boolean hasNext()
        {
            if (pos >= orders.size() ||
                    orders.get(pos) == null)
                return false;
            else
                return true;
        }
    }
}
