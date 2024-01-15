package com.MusicStore.MusicStore.Controller;

import com.MusicStore.MusicStore.Model.Review;
import com.MusicStore.MusicStore.Repository.ReviewRepository;
import com.MusicStore.MusicStore.Service.ReviewService;
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
class ReviewControllerTest {

    @Mock
    private ReviewRepository mockReviewRepository;

    private ReviewService reviewService;

    private ReviewController reviewController;

    private Review testReview;

    @BeforeEach
    void setup(){
        reviewService = spy(new ReviewService(mockReviewRepository));
        reviewController = new ReviewController(reviewService);
        testReview = new Review("1234567", "Comment", 4.5F);
    }

    @Test
    void addReviewWorksAsExpected(){
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), reviewController.addReview(testReview));
        verify(reviewService, times(1)).addReview(testReview);
    }
    @Test
    void updateReviewWorksAsExpected(){
        doNothing().when(reviewService).updateReview(testReview);

        assertEquals(ResponseEntity.ok().build(), reviewController.updateReview(testReview));
        verify(reviewService, times(1)).updateReview(testReview);
    }

    @Test
    void deleteReviewWorksAsExpected(){
        doNothing().when(reviewService).deleteReview(testReview);

        assertEquals(ResponseEntity.status(HttpStatus.NO_CONTENT).build(), reviewController.deleteReview(testReview));
        verify(reviewService, times(1)).deleteReview(testReview);
    }

    @Test
    void getAllReviewsWorksAsExpected(){
        doReturn(List.of(testReview, testReview)).when(mockReviewRepository).findAll();

        assertEquals(ResponseEntity.ok(reviewService.getAllReviews()), reviewController.getAllReviews());
        verify(reviewService, times(2)).getAllReviews();
    }

}