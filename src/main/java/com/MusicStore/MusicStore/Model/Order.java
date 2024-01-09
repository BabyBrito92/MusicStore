package com.MusicStore.MusicStore.Model;

import com.MusicStore.MusicStore.Model.Product;

import java.util.List;

public class Order {
    private List<Product> orderList;
    public float tax;
    public float discount;

    public Order(List<Product> orderList, float tax, float discount) {
        this.orderList = orderList;
        this.tax = tax;
        this.discount = discount;
    }

    public Order(){

    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public List<Product> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Product> orderList) {
        this.orderList = orderList;
    }
}
