package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Controller.AlbumController;
import com.MusicStore.MusicStore.Model.Album;
import com.MusicStore.MusicStore.Repository.AlbumRepository;
import com.MusicStore.MusicStore.Service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AlbumControllerTest {

    @Mock
    private AlbumRepository mockAlbumRepository;
    @InjectMocks
    private AlbumService albumService;

    private AlbumController albumController;
    Album testAlbum1;
    Album testAlbum2;

    @BeforeEach
    public void setUp(){
        testAlbum1 = new Album(Long.valueOf("1234567") , "AlbumTestTitle1", Long.valueOf("1234567"), "AlbumTestLabel1", "ImagePath1", 10, "AlbumTestGenre1", 1990);
        testAlbum2 = new Album(Long.valueOf("2345678") , "AlbumTestTitle2", Long.valueOf("2345678"), "AlbumTestLabel2", "ImagePath2", 20, "AlbumTestGenre2", 1991);
        albumService = new AlbumService(mockAlbumRepository);
        albumController = new AlbumController(albumService);
    }

    @Test
    void getAllReturnsListOfAlbumsAndCorrectResponseEntity(){
        Mockito.when(mockAlbumRepository.findAll()).thenReturn(List.of(testAlbum1, testAlbum2));
        assertEquals(List.of(testAlbum1, testAlbum2), albumService.getAllAlbums());
        assertEquals(ResponseEntity.ok(albumService.getAllAlbums()), albumController.getAllAlbums());
    }

    @Test
    void getAlbumByNameReturnsCorrectAlbumAndResponseEntity(){
        Mockito.when( mockAlbumRepository.findByTitle(testAlbum1.getTitle())).thenReturn(Optional.ofNullable(testAlbum1));
        assertEquals(testAlbum1, albumService.getAlbumByTitle(testAlbum1.getTitle()));
        assertEquals(ResponseEntity.ok(albumService.getAlbumByTitle(testAlbum1.getTitle())), albumController.getAlbumByTitle(testAlbum1.getTitle()));
    }

    @Test
    void addAlbumWorksAsExpectedAndReturnsCorrectResponseEntity(){
        albumService.addAlbum(testAlbum2);
        assertEquals(albumController.addAlbum(testAlbum1),ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @Test
    void updateAlbumWorksAsExpectedAndReturnsCorrectResponseEntity(){
        Mockito.when(mockAlbumRepository.findById(testAlbum2.getID())).thenReturn(Optional.ofNullable(testAlbum2));
        albumService.updateAlbum(testAlbum2);
        assertEquals(albumController.updateAlbum(testAlbum1),ResponseEntity.ok().build());
    }

    @Test
    void deleteAlbumWorksAsExpected(){
        albumService.deleteAlbum(testAlbum2.getID());
        assertEquals(albumController.deleteAlbum(testAlbum1.getID()),ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }


}