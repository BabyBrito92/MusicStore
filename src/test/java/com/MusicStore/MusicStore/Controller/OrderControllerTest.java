package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Order;
import com.MusicStore.MusicStore.Model.Product;
import com.MusicStore.MusicStore.Repository.OrderRepository;
import com.MusicStore.MusicStore.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    @Mock
    private OrderRepository mockOrderRepository;
    private OrderService orderService;
    private OrderController orderController;
    private Order testOrder1;
    private Order testOrder2;
    @BeforeEach
    void setup(){
        List<Product> orderList = List.of();
        testOrder1 = new Order(orderList,0.25F,5);
        testOrder2 = new Order(orderList, 0.5F,.05F);
        orderService = spy(new OrderService(mockOrderRepository));
        orderController = new OrderController(orderService);
    }
    @Test
    void addOrderWorksAsExpected(){
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), orderController.addOrder(testOrder1));
        verify(orderService).addOrder(testOrder1);
    }

    @Test
    void updateOrderWorksAsExpected(){
        doNothing().when(orderService).updateOrder(testOrder1);

        assertEquals(ResponseEntity.ok().build(), orderController.updateOrder(testOrder1));
        verify(orderService).updateOrder(testOrder1);
    }

    @Test
    void deleteAlbumWorksAsExpected(){
        doNothing().when(orderService).deleteOrder(testOrder1);
        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), orderController.deleteOrder(testOrder1));
    }

    @Test
    void getAllAlbumsWorksAsExpected(){
        doReturn(List.of(testOrder1, testOrder2)).when(orderService).getAllOrders();

        assertEquals(ResponseEntity.ok(orderService.getAllOrders()), orderController.getAllOrders());
        verify(orderService, times(2)).getAllOrders();
    }

}