package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviewByReId(int reid);

    int addReview(com.example.g11_cw.Entity.Review review);

    int deleteReview(int rwid);
}
