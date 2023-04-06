package com.chailong.pojo;

import java.io.Serializable;

public class Salary implements Serializable {
    private int salaryId;
    private StaffInformation staffInformation;
    private int salaryyear;
    private int salarymouth;
    private int salarynum;
    private String salarystatue;

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public StaffInformation getStaffInformation() {
        return staffInformation;
    }

    public void setStaffInformation(StaffInformation staffInformation) {
        this.staffInformation = staffInformation;
    }

    public int getSalaryyear() {
        return salaryyear;
    }

    public void setSalaryyear(int salaryyear) {
        this.salaryyear = salaryyear;
    }

    public int getSalarymouth() {
        return salarymouth;
    }

    public void setSalarymouth(int salarymouth) {
        this.salarymouth = salarymouth;
    }

    public int getSalarynum() {
        return salarynum;
    }

    public void setSalarynum(int salarynum) {
        this.salarynum = salarynum;
    }

    public String getSalarystatue() {
        return salarystatue;
    }

    public void setSalarystatue(String salarystatue) {
        this.salarystatue = salarystatue;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", staffInformation=" + staffInformation +
                ", salaryyear=" + salaryyear +
                ", salarymouth=" + salarymouth +
                ", salarynum=" + salarynum +
                ", salarystatue='" + salarystatue + '\'' +
                '}';
    }
}
