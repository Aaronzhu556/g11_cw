package com.example.g11_cw.Entity;

import lombok.Data;

@Data
public class ToBeVerified {

    private int pvid;

    private String pvname;

    private String tvtime;

    private String tvstatus;

    private String tvfinish_time;

    public ToBeVerified() {
    }

    public ToBeVerified(int pvid, String pvname, String tvtime, String tvstatus, String tvfinish_time) {
        this.pvid = pvid;
        this.pvname = pvname;
        this.tvtime = tvtime;
        this.tvstatus = tvstatus;
        this.tvfinish_time = tvfinish_time;
    }
}
