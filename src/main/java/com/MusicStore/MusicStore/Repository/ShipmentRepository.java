package com.MusicStore.MusicStore.Repository;

import com.MusicStore.MusicStore.Model.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShipmentRepository extends MongoRepository<Shipment, String> {
}
