package com.MusicStore.MusicStore.Service;

import com.MusicStore.MusicStore.Model.Shipment;
import com.MusicStore.MusicStore.Repository.ShipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ShipmentService {

    private ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }


    public void addShipment(Shipment shipment){
        shipmentRepository.insert(shipment);
        ResponseEntity.ok(HttpStatus.CREATED);
    }

    public void updateShipment(Shipment shipment){
        Shipment savedShipment = shipmentRepository.findById(shipment.getId())
            .orElseThrow(() -> new RuntimeException(
                    String.format("Cannot Find Shipment by ID %s", shipment.getId())));

        savedShipment.setOrders(shipment.getOrders());
        savedShipment.setDeliveryType(shipment.getDeliveryType());
        savedShipment.setDestinationAddress(shipment.getDestinationAddress());
        savedShipment.setDeliveryType(shipment.getDeliveryType());
        shipmentRepository.save(savedShipment);
    }

    public void deleteShipment(String id){
        shipmentRepository.deleteById(id);
    }

    public List<Shipment> getAllShipments(){
        return shipmentRepository.findAll();
    }

}
