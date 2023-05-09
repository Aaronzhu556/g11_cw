package com.example.g11_cw.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    private int adid;
    private String adname;
    private String adpassword;
    private String ademail;

    public Admin(int adid, String adname, String adpassword, String ademail) {
        this.adid = adid;
        this.adname = adname;
        this.adpassword = adpassword;
        this.ademail = ademail;
    }

    public Admin() {
    }
}
