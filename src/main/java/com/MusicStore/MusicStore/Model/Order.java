package com.MusicStore.MusicStore.Model;

import com.MusicStore.MusicStore.Model.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("Orders")
public class Order {
    @Id
    private String id;
    @Field(name="orderList")
    private List<Product> orderList;
    @Field(name="tax")
    public float tax;

    @Field(name="discount")
    public float discount;

    public Order(List<Product> orderList, float tax, float discount) {
        this.orderList = orderList;
        this.tax = tax;
        this.discount = discount;
    }

    public Order(){

    }

    public String getID() {
        return id;
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
