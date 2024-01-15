package com.MusicStore.MusicStore.Repository;

import com.MusicStore.MusicStore.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
