package com.chailong.pojo;

import java.io.Serializable;

public class Apply  implements Serializable {
    private String account;
    private String applyname;
    private String applysex;
    private int applyage;
    private String applyeducation;
    private String applyidcard;
    private String applyaddress;
    private String applyphonenumber;
    private String applystatue;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getApplysex() {
        return applysex;
    }

    public void setApplysex(String applysex) {
        this.applysex = applysex;
    }

    public int getApplyage() {
        return applyage;
    }

    public void setApplyage(int applyage) {
        this.applyage = applyage;
    }

    public String getApplyeducation() {
        return applyeducation;
    }

    public void setApplyeducation(String applyeducation) {
        this.applyeducation = applyeducation;
    }

    public String getApplyidcard() {
        return applyidcard;
    }

    public void setApplyidcard(String applyidcard) {
        this.applyidcard = applyidcard;
    }

    public String getApplyaddress() {
        return applyaddress;
    }

    public void setApplyaddress(String applyaddress) {
        this.applyaddress = applyaddress;
    }

    public String getApplyphonenumber() {
        return applyphonenumber;
    }

    public void setApplyphonenumber(String applyphonenumber) {
        this.applyphonenumber = applyphonenumber;
    }

    public String getApplystatue() {
        return applystatue;
    }

    public void setApplystatue(String applystatue) {
        this.applystatue = applystatue;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "account='" + account + '\'' +
                ", applyname='" + applyname + '\'' +
                ", applysex='" + applysex + '\'' +
                ", applyage=" + applyage +
                ", applyeducation='" + applyeducation + '\'' +
                ", applyidcard='" + applyidcard + '\'' +
                ", applyaddress='" + applyaddress + '\'' +
                ", applyphonenumber='" + applyphonenumber + '\'' +
                ", applystatue='" + applystatue + '\'' +
                '}';
    }
}
