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

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private ArrayList<Food> foodList;
    private Context context;

    public static class FoodViewHolder extends RecyclerView.ViewHolder{
        public TextView fNameTV;
        public TextView fPriceTV;
        public Button fButton;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            fNameTV = (TextView) itemView.findViewById(R.id.foodProductName);
            fPriceTV = (TextView) itemView.findViewById(R.id.foodProductPrice);
            fButton = (Button) itemView.findViewById(R.id.productFoodButton);
        }
    }

    public FoodAdapter(ArrayList<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_product, parent, false);
        FoodViewHolder foodVH = new FoodViewHolder(view);
        return foodVH;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.fNameTV.setText(foodList.get(position).getFoodName());
        holder.fPriceTV.setText(String.valueOf(foodList.get(position).getFoodPrice())+",-");

        holder.fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailOrderActivity.class);

                intent.putExtra("product_name", foodList.get(position).getFoodName());
                intent.putExtra("product_price", foodList.get(position).getFoodPrice());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
