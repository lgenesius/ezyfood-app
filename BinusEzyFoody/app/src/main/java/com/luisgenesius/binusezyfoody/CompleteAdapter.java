package com.luisgenesius.binusezyfoody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompleteAdapter extends RecyclerView.Adapter<CompleteAdapter.CompleteViewHolder> {
    private ArrayList<Order> orderList;
    private Context context;

    public static class CompleteViewHolder extends RecyclerView.ViewHolder {
        public TextView completeProductNameTV;
        public TextView completeProductQuantityTV;
        public TextView completeProductPriceTV;
        public CompleteViewHolder(@NonNull View itemView) {
            super(itemView);
            completeProductNameTV = (TextView) itemView.findViewById(R.id.completeProductName);
            completeProductPriceTV = (TextView) itemView.findViewById(R.id.completeProductPrice);
            completeProductQuantityTV = (TextView) itemView.findViewById(R.id.completeQuantity);
        }
    }

    public CompleteAdapter(ArrayList<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public CompleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.complete_product, parent, false);
        CompleteViewHolder completeVH = new CompleteViewHolder(view);
        return completeVH;
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteViewHolder holder, int position) {
        holder.completeProductNameTV.setText(orderList.get(position).getProductName());
        if(orderList.get(position).getQuantity() == 1) {
            holder.completeProductQuantityTV.setText(String.valueOf(orderList.get(position).getQuantity()) + " item");
        }
        else {
            holder.completeProductQuantityTV.setText(String.valueOf(orderList.get(position).getQuantity()) + " items");
        }

        holder.completeProductPriceTV.setText("Rp. "+String.valueOf(orderList.get(position).getTotalPrice())+",-");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
