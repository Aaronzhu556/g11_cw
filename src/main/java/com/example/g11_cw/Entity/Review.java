package com.example.g11_cw.Entity;

import lombok.Data;

@Data
public class Review {

    private int rwid;

    private int reid;

    private String rwrate;

    private String rwcomment;

    private String rwtime;

    public Review() {
    }

    public Review(int rwid, int reid, String rwrate, String rwcomment, String rwtime) {
        this.rwid = rwid;
        this.reid = reid;
        this.rwrate = rwrate;
        this.rwcomment = rwcomment;
        this.rwtime = rwtime;
    }
}
