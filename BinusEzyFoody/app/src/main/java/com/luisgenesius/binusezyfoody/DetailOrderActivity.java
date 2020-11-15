package com.luisgenesius.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailOrderActivity extends AppCompatActivity {

    private TextView productTitleTV;
    private TextView productPriceTV;
    private Button orderButton;
    private Button toMyOrderMenuButton;
    private Button orderMoreButton;
    private EditText quantityET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);

        productTitleTV = (TextView) findViewById(R.id.productTitle);
        productPriceTV = (TextView) findViewById(R.id.productCurrency);
        quantityET = (EditText) findViewById(R.id.quantityET);
        orderMoreButton = (Button) findViewById(R.id.orderMoreButton);
        toMyOrderMenuButton = (Button) findViewById(R.id.toOrderMenuButton);

        getExtra();

        orderButton = (Button) findViewById(R.id.orderSubmitButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("product_name") && getIntent().hasExtra("product_price")) {
                    String productName = getIntent().getStringExtra("product_name");
                    int productPrice = getIntent().getIntExtra("product_price", 0);

                    if(quantityET.getText().toString().isEmpty()){
                        Toast.makeText(DetailOrderActivity.this, "Input Quantity Required", Toast.LENGTH_SHORT).show();

                    } else if(Integer.parseInt(quantityET.getText().toString()) < 1){
                        Toast.makeText(DetailOrderActivity.this, "Quantity required more than 0", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int quantity = Integer.parseInt(quantityET.getText().toString());
                        int priceOnQuantity = productPrice*quantity;

                        OrderList orderList = OrderList.getInstance();

                        if(orderList.getOrderList().isEmpty()) {
                            orderList.addOrder(productName, quantity, priceOnQuantity);
                        } else{
                            boolean checkOrder = false;
                            for(int index = 0; index < orderList.getOrderList().size(); index++) {
                                if(orderList.getOrderList().get(index).getProductName().equals(productName)) {
                                    orderList.getOrderList().get(index).setQuantity(orderList.getOrderList().get(index).getQuantity() + quantity);
                                    orderList.getOrderList().get(index).setTotalPrice(productPrice*orderList.getOrderList().get(index).getQuantity());
                                    checkOrder = true;
                                    break;
                                }
                            }

                            if(checkOrder == false) {
                                orderList.addOrder(productName, quantity, priceOnQuantity);
                            }
                        }


                        Toast.makeText(DetailOrderActivity.this, "Order Submitted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        orderMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainMenu();
            }
        });

        toMyOrderMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMyOrderMenu();
            }
        });
    }

    public void goToMyOrderMenu() {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void backToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void getExtra() {
        if(getIntent().hasExtra("product_name") && getIntent().hasExtra("product_price")) {
            String productName = getIntent().getStringExtra("product_name");
            int productPrice = getIntent().getIntExtra("product_price", 0);

            productTitleTV.setText(productName);
            productPriceTV.setText("Rp. "+String.valueOf(productPrice)+",-");
        }
    }
}