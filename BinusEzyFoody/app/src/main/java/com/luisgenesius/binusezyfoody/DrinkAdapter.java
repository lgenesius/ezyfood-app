package com.luisgenesius.binusezyfoody;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder> {
    private ArrayList<Drink> drinkList;
    private Context context;

    public static class DrinkViewHolder extends RecyclerView.ViewHolder {
        public TextView dNameTextView;
        public TextView dPriceTextView;
        public Button dButton;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            dNameTextView = itemView.findViewById(R.id.productName);
            dPriceTextView = itemView.findViewById(R.id.productPrice);
            dButton = itemView.findViewById(R.id.productDrinkButton);
        }
    }

    public DrinkAdapter(ArrayList<Drink> drinkList, Context context) {
        this.drinkList = drinkList;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_product, parent, false);
        DrinkViewHolder drinkVH =   new DrinkViewHolder(view);
        return drinkVH;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        holder.dNameTextView.setText(drinkList.get(position).getProductName());
        holder.dPriceTextView.setText(String.valueOf(drinkList.get(position).getProductPrice()) + ",-");

        holder.dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, DetailOrderActivity.class);

               intent.putExtra("product_name", drinkList.get(position).getProductName());
               intent.putExtra("product_price", drinkList.get(position).getProductPrice());

               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
