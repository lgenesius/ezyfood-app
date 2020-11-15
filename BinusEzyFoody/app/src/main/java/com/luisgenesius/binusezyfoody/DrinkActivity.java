package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button myOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        ArrayList<Drink> drinkList = new ArrayList<>();
        myOrderButton = (Button) findViewById(R.id.drinkGoToOrderButton);

        drinkList.add(new Drink("Mineral Water", 3000));
        drinkList.add(new Drink("Ice Tea", 4000));
        drinkList.add(new Drink("Cole-Cone", 10000));
        drinkList.add(new Drink("Pokeri Good", 6000));
        drinkList.add(new Drink("Kleu Mena", 15000));
        drinkList.add(new Drink("Cytrus Lemon", 10000));
        drinkList.add(new Drink("Rainbow Ice Orange", 17000));
        drinkList.add(new Drink("Chocolate Tea", 8000));
        drinkList.add(new Drink("Milk Shake", 8000));
        drinkList.add(new Drink("Durian Cincau", 15000));
        drinkList.add(new Drink("Fiesta Ice Cream", 20000));
        drinkList.add(new Drink("Herbal Tea", 7000));

        recyclerView = findViewById(R.id.recyclerViewDrinks);
        layoutManager = new LinearLayoutManager(this);
        adapter = new DrinkAdapter(drinkList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        myOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyOrderActivity();
            }
        });
    }

    public void openMyOrderActivity() {
        Intent intent  = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}