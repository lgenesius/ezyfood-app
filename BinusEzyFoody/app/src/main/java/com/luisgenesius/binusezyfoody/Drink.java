package com.luisgenesius.binusezyfoody;

public class Drink {

    private String productName;
    private int productPrice;

    public Drink(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }
}
