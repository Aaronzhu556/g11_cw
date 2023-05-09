package com.example.g11_cw.Entity;

import lombok.Data;

@Data
public class RequestedService {

    private int reid;

    private int cuid;

    private int seid;

    private String sestatus;

    private String sesubmit_time;

    private String sereservation_time;

    private String sefinish_time;

    private String recustomer_phone;

    private String recustomer_address;

    public RequestedService() {
    }

    public RequestedService(int reid, int cuid, int seid, String sestatus, String sesubmit_time, String sereservation_time, String sefinish_time, String recustomer_phone, String recustomer_address) {
        this.reid = reid;
        this.cuid = cuid;
        this.seid = seid;
        this.sestatus = sestatus;
        this.sesubmit_time = sesubmit_time;
        this.sereservation_time = sereservation_time;
        this.sefinish_time = sefinish_time;
        this.recustomer_phone = recustomer_phone;
        this.recustomer_address = recustomer_address;
    }
}
