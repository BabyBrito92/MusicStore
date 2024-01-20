package com.MusicStore.MusicStore.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Products")
public abstract class Product {


    private int productQuantity;
    public Product() {
    }

    public int getProductQuantity(){
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity){
        this.productQuantity = productQuantity;
    }
}
