package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("Shipments")
public class Shipment {
    @Id
    private String id;
    @Field(name="orders")
    private List<Order> orders;
    @Field(name="deliveryType")
    private String deliveryType;
    @Field(name="destinationAddress")
    private String destinationAddress;
    @Field(name="status")
    private String status;

    public Shipment(List<Order> orders, String deliveryType, String destinationAddress, String status) {
        this.orders = orders;
        this.deliveryType = deliveryType;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public Shipment(){

    }

    public String getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
