package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SnackActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button goToMyOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        ArrayList<Snack> snackList = new ArrayList<>();
        goToMyOrderButton = (Button) findViewById(R.id.snackGoToMyOrderButton);

        snackList.add(new Snack("Chitetos", 7000));
        snackList.add(new Snack("Noreo", 10000));
        snackList.add(new Snack("Sugar Leak", 7000));
        snackList.add(new Snack("Happy Chips", 5000));
        snackList.add(new Snack("Corntatos", 9000));
        snackList.add(new Snack("Vortex Crisp", 12000));
        snackList.add(new Snack("Ring O Ring", 5000));
        snackList.add(new Snack("Beta Snacks", 4000));
        snackList.add(new Snack("Super Curio", 6000));
        snackList.add(new Snack("Super Onio", 6000));

        recyclerView = findViewById(R.id.recyclerViewSnacks);
        layoutManager = new LinearLayoutManager(this);
        adapter = new SnackAdapter(snackList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        goToMyOrderButton.setOnClickListener(new View.OnClickListener() {
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