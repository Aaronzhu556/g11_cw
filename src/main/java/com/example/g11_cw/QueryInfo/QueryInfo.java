package com.example.g11_cw.QueryInfo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class QueryInfo {
    private String queryInfo;
    private int pageSize;
    private int pageNum;

    public QueryInfo(String queryInfo, int pageSize, int pageNum) {
        this.queryInfo = queryInfo;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
    public QueryInfo(){}
}
