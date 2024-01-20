package com.MusicStore.MusicStore.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    public Cart(){
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addItem(Product productToBeAdded, int productQuantity){
        boolean notInItems = true;

        for (Product product : products) {
            if (product.equals(productToBeAdded)) {
                product.setProductQuantity(product.getProductQuantity() + productQuantity);
                notInItems = false;
                break;
            }
        }

        if(notInItems){
            productToBeAdded.setProductQuantity(productQuantity);
            products.add(productToBeAdded);
        }
    }

    public void removeItem(Product productToBeRemoved){
        products.remove(productToBeRemoved);
    }

    public void removeItem(Product productToBeRemoved, int quantity){
        for (Product product : products) {
            if (product.equals(productToBeRemoved)) {
                product.setProductQuantity(product.getProductQuantity() - quantity);
                break;
            }
        }
    }


    public void clearCart() {
        products.clear();
    }

    public int getSize() {
        int size = 0;
        for(Product product : products){
            size += product.getProductQuantity();
        }
        return size;
    }
}
