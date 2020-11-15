package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView totalPriceTV;
    private Button payNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        totalPriceTV = (TextView) findViewById(R.id.totalPriceTV);
        payNowButton = (Button) findViewById(R.id.payNowButton);
        int totalPrice = 0;

        ArrayList<Order> orderList = OrderList.getInstance().getOrderList();

        if(!orderList.isEmpty()) {
            for(int index = 0; index < orderList.size(); index++) {
                totalPrice = totalPrice + orderList.get(index).getTotalPrice();
            }

            totalPriceTV.setText("Total : Rp. "+String.valueOf(totalPrice)+",-");
        }

        recyclerView = findViewById(R.id.recyclerViewOrderList);
        layoutManager = new LinearLayoutManager(this);
        adapter = new OrderAdapter(orderList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPayNowActivity(orderList);
            }
        });
    }

    public void goToPayNowActivity(ArrayList<Order> orderList) {
        if(orderList.isEmpty()) {
            Toast.makeText(MyOrderActivity.this, "You have no order", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, OrderCompleteActivity.class);
            finish();
            startActivity(intent);
        }
    }
}