package com.example.g11_cw.Entity;

import lombok.Data;

@Data
public class Service {
    private int seid;
    private String pvid;
    private String sedescription;
    private String seprice;
    private String seavailablity;
    private String seavailable_time;

    private String scname;

    public Service() {
    }

    public Service(int seid, String pvid, String sedescription, String seprice, String seavailablity, String seavailable_time, String scname) {
        this.seid = seid;
        this.pvid = pvid;
        this.sedescription = sedescription;
        this.seprice = seprice;
        this.seavailablity = seavailablity;
        this.seavailable_time = seavailable_time;
        this.scname = scname;
    }
}
