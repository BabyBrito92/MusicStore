package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Artist;
import com.MusicStore.MusicStore.Service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/artist")
public class ArtistController {

    private ArtistService artistService;

    public ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }
    @PostMapping
    public ResponseEntity<Object> addArtist(@RequestBody Artist artist){
        artistService.addArtist(artist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Object> updateArtist(@RequestBody Artist artist){
        artistService.updateArtist(artist);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteArtist(@PathVariable String id){
        artistService.deleteArtist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtist(){
        return ResponseEntity.ok(artistService.getAllArtists());
    }

}
