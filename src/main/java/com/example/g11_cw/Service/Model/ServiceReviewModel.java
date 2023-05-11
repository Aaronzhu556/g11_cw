package com.example.g11_cw.Service.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceReviewModel {
    private int rwid;

    private int reid;

    private int seid;

    private String rwrate;

    private String rwcomment;

    private String rwtime;

    public ServiceReviewModel(){}

    public ServiceReviewModel(int rwid, int reid, int seid, String rwrate, String rwcomment, String rwtime){
        this.rwid = rwid;
        this.reid = reid;
        this.seid = seid;
        this.rwrate = rwrate;
        this.rwcomment = rwcomment;
        this.rwtime = rwtime;
    }

}
