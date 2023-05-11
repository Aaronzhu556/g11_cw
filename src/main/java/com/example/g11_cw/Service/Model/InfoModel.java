package com.example.g11_cw.Service.Model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfoModel {
    private String queryName;
    private String queryCategory;
    private String queryArea;
    private int pageSize;
    private int pageNum;

    public InfoModel() {
    }

    public InfoModel(String queryName, String queryCategory, String queryArea, int pageSize, int pageNum) {
        this.queryName = queryName;
        this.queryCategory = queryCategory;
        this.queryArea = queryArea;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}