package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.Entity.Review;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.RequestedServiceService;
import com.example.g11_cw.Service.Interface.ReviewService;
import com.example.g11_cw.Service.Model.ServiceReviewModel;
import com.example.g11_cw.Utils.TimeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewController {


    private ReviewService reviewService;

    private RequestedServiceService requestedServiceService;


    @RequestMapping("/getreviews")
    public MyResponse getReviews(@RequestBody int reid){

        try {
            List<Review> allreview = reviewService.getAllReviewByReId(reid);
            if (allreview.size() != 0) return new MyResponse("200","查询成功",allreview);
            else return new MyResponse("201","没有数据",null);
        }catch (Exception e) {
            return new MyResponse("202","查询出错",null);
        }
    }

    @RequestMapping("/getreviewbyseid")
    public MyResponse getReviewsBySeid(@RequestBody int seid){
        try {
            List<ServiceReviewModel> serviceReviewModel = new ArrayList<>();
            List<RequestedService> requestedService = requestedServiceService.getAllRequestedServiceBySeId(seid);
            for(RequestedService request_iter : requestedService){
               List<Review> reviewbyseid = reviewService.getAllReviewByReId(request_iter.getReid());
               for(Review review_iter : reviewbyseid){
                   serviceReviewModel.add(new ServiceReviewModel(
                           review_iter.getRwid(),
                           review_iter.getReid(),
                           request_iter.getSeid(),
                           review_iter.getRwrate(),
                           review_iter.getRwcomment(),
                           review_iter.getRwtime()));
               }
            }
            if (serviceReviewModel.size() != 0) return new MyResponse("200","查询成功",serviceReviewModel);
            else return new MyResponse("201","没有数据",null);
        } catch (Exception e){
            return new MyResponse("202","查询出错",null);
        }
    }

    @RequestMapping("/addreview")
    public MyResponse addReview(@RequestBody Review review){
        try{
            review.setRwtime(TimeUtils.getCurrentDateTime());
            int i = reviewService.addReview(review);
            if (i!=0) return new MyResponse("200","新增review成功",null);
            else return new MyResponse("201","新增review失败,请重试",null);
        }
        catch (Exception e){
            return new MyResponse("202","系统出错",null);
        }
    }

    @RequestMapping("/deletereview")
    public MyResponse deleteReview(@RequestParam int rwid){
        try{
            int i = reviewService.deleteReview(rwid);
            if (i!=0) return MyResponse.builder().code("200").msg("删除成功").info(null).build();
            else return MyResponse.builder().code("201").msg("删除失败").info(null).build();
        }catch (Exception e){
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }
    }
}
