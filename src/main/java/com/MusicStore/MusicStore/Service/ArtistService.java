package com.MusicStore.MusicStore.Service;

import com.MusicStore.MusicStore.Model.Artist;
import com.MusicStore.MusicStore.Repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public void addArtist(Artist artist){
        artistRepository.insert(artist);
    }

    public void updateArtist(Artist artist){
        Artist savedArtist = artistRepository.findById(artist.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Artist by ID %s", artist.getId())));
        savedArtist.setArtistName(artist.getArtistName());
        savedArtist.setBio(artist.getBio());
        artistRepository.save(savedArtist);
    }

    public void deleteArtist(String id){
        artistRepository.deleteById(id);
    }

    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }
}
