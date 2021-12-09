package com.example.shoppingcartfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<Product> products;

    public OrderAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pName, pCost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.orderProductName);
            pCost = (TextView) itemView.findViewById(R.id.orderProductCost);
        }
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        String productName = products.get(position).getName();
        String productCost = Double.toString(products.get(position).getCost());
        holder.pName.setText(productName);
        holder.pCost.setText(productCost);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
