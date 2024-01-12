package com.MusicStore.MusicStore.Repository;

import com.MusicStore.MusicStore.Model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {
}
