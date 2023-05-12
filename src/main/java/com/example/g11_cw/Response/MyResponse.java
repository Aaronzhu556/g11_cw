package com.example.g11_cw.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyResponse {
    private String code;
    private String msg;
    private Object info;

    public MyResponse() {
    }

    public MyResponse(String code, String msg, Object info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }
}
