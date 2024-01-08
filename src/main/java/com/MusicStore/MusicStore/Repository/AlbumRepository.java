package com.MusicStore.MusicStore.Repository;

import com.MusicStore.MusicStore.Model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AlbumRepository extends MongoRepository<Album, String> {

    @Query("{'title': ?0}")
    Optional<Album> findByTitle(String title);


}
