package com.example.shoppingcartfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private ArrayList<Product> products;
    private ProductViewModel productViewModel;

    public InventoryAdapter(ArrayList<Product> products) {
        this.products = products;
        this.productViewModel = productViewModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pName, pCost;
        private Button viewProduct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.productNameInv);
            pCost = (TextView) itemView.findViewById(R.id.productCostInv);
            //viewProduct = (Button) itemView.findViewById(R.id.deleteProduct);
        }
    }

    @NonNull
    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapter.ViewHolder holder, int position) {
        String productName = products.get(position).getName();
        String productCost = Double.toString(products.get(position).getCost());
        holder.pName.setText(productName);
        holder.pCost.setText(productCost);/*
        holder.viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product currentProduct = products.get(holder.getAdapterPosition());
                // productViewModel.setProduct(currentProduct);
                ProductDB productDB = ProductDB.getInstance(view.getContext());
                productDB.getProduct()
                currentProduct.
                Navigation.findNavController(view).navigate(R.id.productPageFragment);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
