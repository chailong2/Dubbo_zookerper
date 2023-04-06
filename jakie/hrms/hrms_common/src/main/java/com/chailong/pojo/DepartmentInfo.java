package com.chailong.pojo;

import java.io.Serializable;

public class DepartmentInfo implements Serializable {
    private int detid;    //部门id
    private String detname;   //部门名称
    private String dephonenumber;             //部门联系电话

    public int getDetid() {
        return detid;
    }

    public void setDetid(int detid) {
        this.detid = detid;
    }

    public String getDetname() {
        return detname;
    }

    public void setDetname(String detname) {
        this.detname = detname;
    }

    public String getDephonenumber() {
        return dephonenumber;
    }

    public void setDephonenumber(String dephonenumber) {
        this.dephonenumber = dephonenumber;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "detid=" + detid +
                ", detname='" + detname + '\'' +
                ", dephonenumber='" + dephonenumber + '\'' +
                '}';
    }
}
