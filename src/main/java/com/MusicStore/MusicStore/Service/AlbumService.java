package com.MusicStore.MusicStore.Service;

import com.MusicStore.MusicStore.Model.Album;
import com.MusicStore.MusicStore.Repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    public void addAlbum(Album album){
        albumRepository.insert(album);
    }

    public void updateAlbum(Album album){
        Album savedAlbum = albumRepository.findById(album.getID())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Album by ID %s", album.getID())));

        savedAlbum.setAlbumID(album.getAlbumID());
        savedAlbum.setTitle(album.getTitle());
        savedAlbum.setLabel(album.getLabel());
        savedAlbum.setImagePath(album.getImagePath());
        savedAlbum.setQuantity(album.getQuantity());
        savedAlbum.setGenre(album.getGenre());
        savedAlbum.setReleaseDate(album.getReleaseDate());

        albumRepository.save(savedAlbum);
    }

    public List<Album> getAllAlbums(){
        return albumRepository.findAll();
    }


    public Album getAlbumByTitle(String title){
        System.out.println(title);
        return albumRepository.findByTitle(title).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Album by Name %s", title)));
    }

    public void deleteAlbum(String id){
        albumRepository.deleteById(id);
    }
}
