package com.MusicStore.MusicStore.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp(){
        cart = new Cart();
        cart.addItem(new Album(1234567L, "Parachutes", 2345678L, "Parlophone", "imagePath1", 100, "Alternative Rock", 2000), 1);
        cart.addItem(new Album(7654321L, "Damn", 8765432L, "Interscope", "imagePath2", 50, "Hip-Hop", 2017), 1);
        cart.addItem(new Album(3691215L, "Hybrid Theory", 1234567L, "Warner Bros.", "imagePath3", 50, "Alternative Rock", 2000), 1);
    }

    @Test
    void addingNewProductShowsCorrectProductSizeAndQuantity() {
        Product productToBeAdded = new Album(5102040L, "Meteora", 1234567L, "Warner Bros.", "imagePath4", 50, "Alternative Rock", 2003);
        assertEquals(3, cart.getProducts().size());

        cart.addItem(productToBeAdded, 1);
        assertEquals(4, cart.getProducts().size());

    }

    @Test
    void addingDuplicateProductShowsCorrectProductSizeAndQuantity(){
        Product productToBeAdded = cart.getProducts().get(2);
        assertEquals(3, cart.getProducts().size());

        cart.addItem(productToBeAdded, 2);
        assertEquals(3, cart.getProducts().size());
    }

    @Test
    void clearCartMethodReturnsEmptyList(){
        cart.clearCart();
        assertEquals(0, cart.getSize());
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    void getSizeReturnsCorrectAmountOfItemsInCart(){
        assertEquals(3, cart.getSize());

        cart.addItem(cart.getProducts().get(0),2 );
        cart.addItem(cart.getProducts().get(0),3 );
        cart.addItem(cart.getProducts().get(0),4 );
        assertEquals(12, cart.getSize());
    }


}