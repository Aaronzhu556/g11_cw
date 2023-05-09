package com.example.g11_cw.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String res_code;
    private String res_msg;
    private Object res_object;

    public Response(String res_code, String res_msg, Object res_object) {
        this.res_code = res_code;
        this.res_msg = res_msg;
        this.res_object = res_object;
    }
}
