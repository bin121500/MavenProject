package com.xiaobin.project.model;

public class Order {
    private int uid;
    private String orderinf;

    public Order(int uid, String orderinf) {
        this.uid = uid;
        this.orderinf = orderinf;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "uid=" + uid +
                ", orderinf='" + orderinf + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getOrderinf() {
        return orderinf;
    }

    public void setOrderinf(String orderinf) {
        this.orderinf = orderinf;
    }
}
