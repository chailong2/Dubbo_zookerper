package com.chailong.pojo;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
   private int staffid;
   private int deptid;
   private String staffoffice;

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getStaffoffice() {
        return staffoffice;
    }

    public void setStaffoffice(String staffoffice) {
        this.staffoffice = staffoffice;
    }

    @Override
    public String toString() {
        return "Department{" +
                "staffid=" + staffid +
                ", deptid=" + deptid +
                ", staffoffice='" + staffoffice + '\'' +
                '}';
    }
}
