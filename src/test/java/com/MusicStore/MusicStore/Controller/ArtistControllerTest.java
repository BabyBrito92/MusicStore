package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Artist;
import com.MusicStore.MusicStore.Repository.ArtistRepository;
import com.MusicStore.MusicStore.Service.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ArtistControllerTest {
    @Mock
    private ArtistRepository mockArtistRepository;
    private ArtistService artistService;
    private ArtistController artistController;
    private Artist testArtist;

    @BeforeEach
    void setup(){
        testArtist = new Artist("Kurt Cobain", "Lead Singer for Nirvana");
        artistService = spy(new ArtistService(mockArtistRepository));
        artistController = new ArtistController(artistService);
    }

    @Test
    void addArtistWorksAsExpected(){
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), artistController.addArtist(testArtist));
        verify(artistService, times(1)).addArtist(testArtist);
    }

    @Test
    void updateArtistWorksAsExpected(){
        doNothing().when(artistService).updateArtist(testArtist);

        assertEquals(ResponseEntity.ok().build(), artistController.updateArtist(testArtist));
        verify(artistService, times(1)).updateArtist(testArtist);
    }

    @Test
    void deleteArtistWorksAsExpected(){
        doNothing().when(artistService).deleteArtist(testArtist.getId());

        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), artistController.deleteArtist(testArtist.getId()));
        verify(artistService, times(1)).deleteArtist(testArtist.getId());
    }

    @Test
    void getAllArtistsWorksAsExpected(){
        doReturn(List.of()).when(mockArtistRepository).findAll();

        assertEquals(ResponseEntity.ok(artistService.getAllArtists()), artistController.getAllArtist());
        verify(artistService, times(2)).getAllArtists();
    }

}