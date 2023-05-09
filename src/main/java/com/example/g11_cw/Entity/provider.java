package com.example.g11_cw.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class provider {
    private int pvid;
    private String pvname;
    private String pvaddress;
    private String pvemail;
    private String pvdescription;
    private String pvphone;
    private String pvis_approved;
    private String pvpassword;

    public provider() {
    }

    public provider(int pvid, String pvname, String pvaddress, String pvemail, String pvdescription, String pvphone, String pvis_approved, String pvpassword) {
        this.pvid = pvid;
        this.pvname = pvname;
        this.pvaddress = pvaddress;
        this.pvemail = pvemail;
        this.pvdescription = pvdescription;
        this.pvphone = pvphone;
        this.pvis_approved = pvis_approved;
        this.pvpassword = pvpassword;
    }
}
