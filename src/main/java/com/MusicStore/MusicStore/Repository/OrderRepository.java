package com.MusicStore.MusicStore.Repository;


import com.MusicStore.MusicStore.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String>  {

//    @Query("{'orderDate': ?0}")
//    Optional<Album> findByTitle(Date orderDate);

}
