package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.Entity.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<Review> getAllReviewByReId(int reid);

    //List<Review> getServiceReviewBySeid(int seid);

    int addReview(Review review);

    int deleteReview(int rwid);

}
