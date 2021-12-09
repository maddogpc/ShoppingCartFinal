package com.example.shoppingcartfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> products;
    private ProductViewModel productViewModel;

    public ProductAdapter(ArrayList<Product> products, ProductViewModel productViewModel) {
        this.products = products;
        this.productViewModel = productViewModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pName, pCost;
        private Button viewProduct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.productName);
            pCost = (TextView) itemView.findViewById(R.id.productCost);
            viewProduct = (Button) itemView.findViewById(R.id.viewProduct);
        }
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        String productName = products.get(position).getName();
        String productCost = Double.toString(products.get(position).getCost());
        holder.pName.setText(productName);
        holder.pCost.setText(productCost);
        holder.viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.productPageFragment);
                Product currentProduct = products.get(holder.getAdapterPosition());
                productViewModel.setProduct(currentProduct);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
