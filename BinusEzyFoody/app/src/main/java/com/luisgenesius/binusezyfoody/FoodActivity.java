package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button myOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ArrayList<Food> foodList = new ArrayList<>();
        myOrderButton = (Button) findViewById(R.id.foodGoToOrderButton);

        foodList.add(new Food("Chicken Satay", 35000));
        foodList.add(new Food("Beef Satay", 50000));
        foodList.add(new Food("Cap Cay", 25000));
        foodList.add(new Food("Kwetiau", 20000));
        foodList.add(new Food("Fried Rice", 20000));
        foodList.add(new Food("Salty Noodle", 20000));
        foodList.add(new Food("Padang Set", 70000));
        foodList.add(new Food("Omelet Egg", 12000));
        foodList.add(new Food("White Rice", 7000));
        foodList.add(new Food("Chicken Soto", 15000));
        foodList.add(new Food("Yellow Rice Set", 15000));

        recyclerView = findViewById(R.id.recyclerViewFoods);
        layoutManager = new LinearLayoutManager(this);
        adapter = new FoodAdapter(foodList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        myOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMyOrderActivity();
            }
        });
    }

    public void goToMyOrderActivity() {
        Intent intent  = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}