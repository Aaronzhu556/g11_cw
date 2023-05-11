package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.Entity.Review;
import com.example.g11_cw.Mapper.ReviewMapper;
import com.example.g11_cw.Service.Interface.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired(required = false)
    ReviewMapper reviewMapper;

    @Override
    public List<Review> getAllReviewByReId(int reid) {
        return reviewMapper.getAllReviewByReId(reid);
    }

    @Override
    public int addReview(Review review) {
        return reviewMapper.addReview(review);
    }

    @Override
    public int deleteReview(int rwid) {
        return reviewMapper.deleteReview(rwid);
    }
}
