package com.luisgenesius.binusezyfoody;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private ArrayList<Order> orderList;
    private Context context;

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public TextView orderProductNameTV;
        public TextView orderQuantityTV;
        public TextView ordertotalPriceTV;
        public Button deleteButton;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderProductNameTV = itemView.findViewById(R.id.orderProductName);
            orderQuantityTV = itemView.findViewById(R.id.orderQuantity);
            ordertotalPriceTV = itemView.findViewById(R.id.orderProductPrice);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    public OrderAdapter(ArrayList<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_product, parent, false);
        OrderViewHolder orderVH = new OrderViewHolder(view);
        return orderVH;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.orderProductNameTV.setText(orderList.get(position).getProductName());
        if(orderList.get(position).getQuantity() == 1) {
            holder.orderQuantityTV.setText(String.valueOf(orderList.get(position).getQuantity()) + " item");
        }
        else {
            holder.orderQuantityTV.setText(String.valueOf(orderList.get(position).getQuantity()) + " items");
        }
        holder.ordertotalPriceTV.setText("Rp. "+String.valueOf(orderList.get(position).getTotalPrice())+",-");

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderList.remove(position);

                Intent intent = new Intent(context, MyOrderActivity.class);
                ((MyOrderActivity)context).finish();
                ((MyOrderActivity)context).overridePendingTransition(0,0);
                context.startActivity(intent);
                ((MyOrderActivity)context).overridePendingTransition(0,0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
