package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Album;
import com.MusicStore.MusicStore.Repository.AlbumRepository;
import com.MusicStore.MusicStore.Service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AlbumControllerTest {

    @Mock
    AlbumRepository mockAlbumRepo;

    private AlbumService mockAlbumService;

    private AlbumController albumController;
    Album testAlbum1;
    Album testAlbum2;

    @BeforeEach
    public void setUp(){
        testAlbum1 = new Album(Long.valueOf("1234567") , "AlbumTestTitle1", Long.valueOf("1234567"), "AlbumTestLabel1", "ImagePath1", 10, "AlbumTestGenre1", 1990);
        testAlbum2 = new Album(Long.valueOf("2345678") , "AlbumTestTitle2", Long.valueOf("2345678"), "AlbumTestLabel2", "ImagePath2", 20, "AlbumTestGenre2", 1991);
        mockAlbumService = spy(new AlbumService(mockAlbumRepo));
        albumController = new AlbumController(mockAlbumService);
    }

    @Test
    void getAllAlbumsReturnsListOfAlbumsAndCorrectResponseEntity(){
        doReturn(List.of(testAlbum1, testAlbum2)).when(mockAlbumService).getAllAlbums();

        assertEquals(ResponseEntity.ok(mockAlbumService.getAllAlbums()), albumController.getAllAlbums());
        verify(mockAlbumService, times(2)).getAllAlbums();
    }

    @Test
    void getAlbumByNameReturnsCorrectAlbumAndResponseEntity(){;
        doReturn(testAlbum1).when(mockAlbumService).getAlbumByTitle(testAlbum1.getTitle());

        assertEquals(ResponseEntity.ok(mockAlbumService.getAlbumByTitle(testAlbum1.getTitle())), albumController.getAlbumByTitle(testAlbum1.getTitle()));
        verify(mockAlbumService, times(2)).getAlbumByTitle(testAlbum1.getTitle());
    }

    @Test
    void addAlbumWorksAsExpectedAndReturnsCorrectResponseEntity(){
        assertEquals(albumController.addAlbum(testAlbum1),ResponseEntity.status(HttpStatus.CREATED).build());
        verify(mockAlbumService).addAlbum(testAlbum1);
    }

    @Test
    void updateAlbumWorksAsExpectedAndReturnsCorrectResponseEntity(){
        doNothing().when(mockAlbumService).updateAlbum(testAlbum1);

        assertEquals(albumController.updateAlbum(testAlbum1),ResponseEntity.ok().build());
        verify(mockAlbumService, times(1)).updateAlbum(testAlbum1);
    }

    @Test
    void deleteAlbumWorksAsExpected(){
        assertEquals(albumController.deleteAlbum(testAlbum1.getID()),ResponseEntity.status(HttpStatus.NO_CONTENT).build());
        verify(mockAlbumService).deleteAlbum(testAlbum1.getID());
    }


}