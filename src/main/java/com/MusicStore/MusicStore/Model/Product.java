package com.MusicStore.MusicStore.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public abstract class Product {

    @Field(name="quantity")
    private int quantity;


    public Product() {
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
