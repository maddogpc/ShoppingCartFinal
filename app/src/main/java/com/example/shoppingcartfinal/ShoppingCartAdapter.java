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

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    private ShoppingCart shoppingCart;

    public ShoppingCartAdapter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pName, pCost;
        private Button viewProduct;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.productNameCart);
            pCost = (TextView) itemView.findViewById(R.id.productCostCart);
            viewProduct = (Button) itemView.findViewById(R.id.removeProductFromCart);
        }
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoppingcart_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ViewHolder holder, int position) {
        ArrayList<Product> products = shoppingCart.getProducts();
        String productName = products.get(position).getName();
        String productCost = Double.toString(products.get(position).getCost());
        holder.pName.setText(productName);
        holder.pCost.setText(productCost);
        holder.viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product currentProduct = products.get(holder.getAdapterPosition());
                shoppingCart.removeFromShoppingCart(currentProduct);
                Navigation.findNavController(view).navigate(R.id.shoppingCartFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCart.getProducts().size();
    }
}
