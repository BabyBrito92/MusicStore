package com.MusicStore.MusicStore.Service;

import com.MusicStore.MusicStore.Model.Review;
import com.MusicStore.MusicStore.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(Review review){
        reviewRepository.insert(review);
    }

    public void updateReview(Review review){
        Review savedReview = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Order by ID %s", review.getId())));

        savedReview.setAccountiD(review.getAccountiD());
        savedReview.setRating(review.getRating());
        savedReview.setComment(review.getComment());

        reviewRepository.save(savedReview);
    }

    public void deleteReview(Review review){
        reviewRepository.delete(review);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }
}
