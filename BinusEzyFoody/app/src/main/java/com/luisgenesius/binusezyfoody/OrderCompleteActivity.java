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

public class OrderCompleteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button mainMenuButton;
    private TextView paidTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        ArrayList<Order> orderList = new ArrayList<>();

        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
        paidTotal = (TextView) findViewById(R.id.totalCompleteTV);

        int total = 0;

        for(int i=0; i < OrderList.getInstance().getOrderList().size(); i++) {
            orderList.add(new Order(OrderList.getInstance().getOrderList().get(i).getProductName(), OrderList.getInstance().getOrderList().get(i).getQuantity(), OrderList.getInstance().getOrderList().get(i).getTotalPrice()));
            total = total + OrderList.getInstance().getOrderList().get(i).getTotalPrice();
        }

        paidTotal.setText("Paid Total : Rp. "+total+",-");

        OrderList.getInstance().getOrderList().clear();

        recyclerView = findViewById(R.id.recyclerViewOrderComplete);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CompleteAdapter(orderList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainMenu();
            }
        });
    }

    public void backToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}