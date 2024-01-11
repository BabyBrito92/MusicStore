package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Order;
import com.MusicStore.MusicStore.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping
    public ResponseEntity<Order> deleteOrder(@PathVariable Order order){
        orderService.deleteOrder(order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
