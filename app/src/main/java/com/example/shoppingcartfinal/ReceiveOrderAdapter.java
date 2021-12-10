package com.example.shoppingcartfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReceiveOrderAdapter extends RecyclerView.Adapter<ReceiveOrderAdapter.ViewHolder> {

    private OrderDB orderDB;
    private User seller;
    ArrayList<Order> filteredOrders;

    public ReceiveOrderAdapter(ArrayList<Order> filteredOrders, User seller) {
        this.seller = seller;
        this.filteredOrders = filteredOrders;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bProd, bName, bCNum, bSD;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bProd = (TextView) itemView.findViewById(R.id.orderProductName);
            bName = (TextView) itemView.findViewById(R.id.orderProductCost);
        }
    }

    @NonNull
    @Override
    public ReceiveOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiveOrderAdapter.ViewHolder holder, int position) throws NullPointerException {

        String s = "";
        for (int i = 0; i < filteredOrders.get(position).getProducts().size(); i++)
        {
            s = s + " " + filteredOrders.get(position).getProducts().get(i) + " ";
        }
        String boughtProd = s;
        String buyerName = filteredOrders.get(position).getBuyerName();
        String cardNum = filteredOrders.get(position).getCardInfo().getCarNum();
        holder.bProd.setText(s);
        holder.bName.setText(buyerName);
        holder.bCNum.setText(cardNum);
        holder.bSD.setText(cardNum);
    }

    @Override
    public int getItemCount() {
        return filteredOrders.size();
    }
}
