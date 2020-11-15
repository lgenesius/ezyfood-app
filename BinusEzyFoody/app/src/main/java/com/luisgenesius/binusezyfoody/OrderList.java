package com.luisgenesius.binusezyfoody;

import java.util.ArrayList;

public class OrderList {
    private static OrderList oL = null;

    private ArrayList<Order> orderList = new ArrayList<>();

    private OrderList() {

    }

    public synchronized static OrderList getInstance() {
        if(oL == null) {
            oL = new OrderList();
        }

        return oL;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(String productName, int quantity, int totalPrice) {
        orderList.add(new Order(productName, quantity, totalPrice));
    }
}
