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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnackViewHolder> {
    private ArrayList<Snack> snackList;
    private Context context;

    public static class SnackViewHolder extends RecyclerView.ViewHolder{
        public TextView sNameTV;
        public TextView sPriceTV;
        public Button sButton;

        public SnackViewHolder(@NonNull View itemView) {
            super(itemView);
            sNameTV = (TextView) itemView.findViewById(R.id.snackProductName);
            sPriceTV = (TextView) itemView.findViewById(R.id.snackProductPrice);
            sButton = (Button) itemView.findViewById(R.id.productSnackButton);
        }
    }

    public SnackAdapter(ArrayList<Snack> snackList, Context context) {
        this.snackList = snackList;
        this.context = context;
    }

    @NonNull
    @Override
    public SnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.snack_product, parent, false);
        SnackViewHolder snackVH = new SnackViewHolder(view);
        return snackVH;
    }

    @Override
    public void onBindViewHolder(@NonNull SnackViewHolder holder, int position) {
        holder.sNameTV.setText(snackList.get(position).getSnackName());
        holder.sPriceTV.setText(String.valueOf(snackList.get(position).getSnackPrice())+",-");

        holder.sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailOrderActivity.class);

                intent.putExtra("product_name", snackList.get(position).getSnackName());
                intent.putExtra("product_price", snackList.get(position).getSnackPrice());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return snackList.size();
    }
}
