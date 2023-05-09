package com.example.g11_cw.QueryInfo;

import lombok.Data;

@Data
public class QueryInfo {
    private String queryInfo;
    private int pageSize;
    private int pageNum;

    public QueryInfo(String queryInfo, int pageSize, int pageNum) {
        this.queryInfo = queryInfo;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}
