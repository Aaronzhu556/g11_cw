package com.example.g11_cw.Entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class customer {
    private int cuid;
    private String cuname;
    private String cuemail;
    private String cudescription;
    private String cupassword;
    private String cuphone;
    private String cuaddress;
    private String cuadvator;

    public customer() {
    }

    public customer(int cuid, String cuname, String cuemail, String cudescription, String cupassword, String cuphone, String cuaddress, String cuadvator) {
        this.cuid = cuid;
        this.cuname = cuname;
        this.cuemail = cuemail;
        this.cudescription = cudescription;
        this.cupassword = cupassword;
        this.cuphone = cuphone;
        this.cuaddress = cuaddress;
        this.cuadvator = cuadvator;
    }
}
