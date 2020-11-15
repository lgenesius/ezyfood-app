package com.luisgenesius.binusezyfoody;

public class Snack {

    private String snackName;
    private int snackPrice;

    public Snack(String snackName, int snackPrice) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public int getSnackPrice() {
        return snackPrice;
    }

    public void setSnackPrice(int snackPrice) {
        this.snackPrice = snackPrice;
    }
}
