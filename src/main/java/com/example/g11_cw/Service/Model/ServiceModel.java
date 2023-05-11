package com.example.g11_cw.Service.Model;

import com.example.g11_cw.Entity.Provider;

public class ServiceModel {
    private int seid;
    private Provider provider;
    private String sedescription;
    private String seprice;
    private String seavailablity;
    private String seavailable_time;

    private String scname;

    public ServiceModel() {
    }

    public ServiceModel(int seid, Provider provider, String sedescription, String seprice, String seavailablity, String seavailable_time, String scname) {
        this.seid = seid;
        this.provider = provider;
        this.sedescription = sedescription;
        this.seprice = seprice;
        this.seavailablity = seavailablity;
        this.seavailable_time = seavailable_time;
        this.scname = scname;
    }
}
