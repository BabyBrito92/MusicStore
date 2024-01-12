package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Shipment;
import com.MusicStore.MusicStore.Service.ShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService){
        this.shipmentService = shipmentService;
    }

    public ShipmentController(){

    }

    @PostMapping
    public ResponseEntity addShipment(@RequestBody Shipment shipment){
        shipmentService.addShipment(shipment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateShipment(@RequestBody Shipment shipment){
        shipmentService.updateShipment(shipment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteShipment(@PathVariable String id){
        shipmentService.deleteShipment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments(){
        return ResponseEntity.ok(shipmentService.getAllShipments());
    }
}
