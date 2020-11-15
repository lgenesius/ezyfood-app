package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button drinkButton;
    private Button snackButton;
    private Button foodButton;
    private Button myOrderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drinkButton =(Button)findViewById(R.id.drinkButtonMenu);
        snackButton = (Button) findViewById(R.id.snackButtonMenu);
        foodButton = (Button) findViewById(R.id.foodButtonMenu);
        myOrderButton = (Button) findViewById(R.id.myOrderButton);


        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrinksMenu();
            }
        });

        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSnacksMenu();
            }
        });

        myOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyOrderActivity();
            }
        });

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodsMenu();
            }
        });
    }

    public void openFoodsMenu() {
        Intent intent  = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    public void openMyOrderActivity() {
        Intent intent  = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void openSnacksMenu() {
        Intent intent = new Intent(this, SnackActivity.class);
        startActivity(intent);
    }

    public void openDrinksMenu() {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }
}