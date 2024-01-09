package com.MusicStore.MusicStore.Model;

public abstract class Product {

    int quantity;

    public Product(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
