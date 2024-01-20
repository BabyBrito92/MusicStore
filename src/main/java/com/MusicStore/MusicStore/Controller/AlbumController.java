package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Album;
import com.MusicStore.MusicStore.Service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/album")
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity addAlbum(@RequestBody Album album){
        albumService.addAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateAlbum(@RequestBody Album album){
        albumService.updateAlbum(album);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(){
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/{title}")
    public ResponseEntity<Album> getAlbumByTitle(@PathVariable String title){
        return ResponseEntity.ok(albumService.getAlbumByTitle(title));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAlbum(@PathVariable String id){
        albumService.deleteAlbum(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
