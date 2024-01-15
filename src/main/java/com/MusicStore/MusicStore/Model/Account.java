package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Accounts")
public class Account {

    @Id
    private String id;

    @Field(name="firstName")
    private String firstName;

    @Field(name="lastName")
    private String lastName;

    @Field(name="payment")
    private Payment[] payments;

    @Field(name="shipments")
    private Shipment[] shipments;

    @Field(name="orders")
    private Order[] orders;

    @Field(name="addresses")
    private String[] addresses;

    @Field(name="reviews")
    private Review[] reviews;

    private Cart cart;
}
