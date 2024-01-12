package com.MusicStore.MusicStore.Controller;
import com.MusicStore.MusicStore.Model.Shipment;
import com.MusicStore.MusicStore.Repository.ShipmentRepository;
import com.MusicStore.MusicStore.Service.ShipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ShipmentControllerTest {
    @Mock
    private ShipmentRepository mockShipmentRepository;

    private ShipmentService shipmentService;

    private ShipmentController shipmentController;

    private Shipment testShipment;

    @BeforeEach
    void setUp() {
        testShipment = new Shipment(List.of(), "", "", "");
        shipmentService = spy(new ShipmentService(mockShipmentRepository));
        shipmentController = new ShipmentController(shipmentService);
    }

    @Test
    void addShipmentWorksAsExpected(){
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), shipmentController.addShipment(testShipment));
        verify(shipmentService, times(1)).addShipment(testShipment);
    }

    @Test
    void updateShipmentWorksAsExpected(){
        doNothing().when(shipmentService).updateShipment(testShipment);

        assertEquals(shipmentController.updateShipment(testShipment),ResponseEntity.ok().build());
        verify(shipmentService, times(1)).updateShipment(testShipment);
    }

    @Test
    void deleteShipmentWorksAsExpected(){
        assertEquals(shipmentController.deleteShipment(testShipment.getId()),ResponseEntity.status(HttpStatus.NO_CONTENT).build());
        verify(shipmentService).deleteShipment(testShipment.getId());
    }
    @Test
    void getAllShipmentsWorksAsExpected(){
        doReturn(List.of(testShipment)).when(shipmentService).getAllShipments();

        assertEquals(ResponseEntity.ok(shipmentService.getAllShipments()), shipmentController.getAllShipments());
        verify(shipmentService, times(2)).getAllShipments();
    }

}