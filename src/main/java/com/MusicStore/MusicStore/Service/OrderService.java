package com.MusicStore.MusicStore.Service;

import com.MusicStore.MusicStore.Model.Album;
import com.MusicStore.MusicStore.Model.Order;
import com.MusicStore.MusicStore.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order){
        orderRepository.insert(order);
    }

    public void updateOrder(Order order){
        Order savedOrder = orderRepository.findById(order.getID())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Order by ID %s", order.getID())));

        savedOrder.setOrderList(order.getOrderList());
        savedOrder.setTax(order.getTax());
        savedOrder.setDiscount(order.getDiscount());

        orderRepository.save(savedOrder);
    }

    public void deleteOrder(Order oder){
        orderRepository.delete(oder);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

}
