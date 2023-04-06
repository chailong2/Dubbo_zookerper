package com.chailong.pojo;

import java.io.Serializable;

public class StaffInformation implements Serializable {
  private long staffId;
  private String staffname;
  private long staffage;
  private String staffsex;
  private String educationBackground;
  private String duty;
  private String idcard;
  private String address;
  private String phonenumber;
  public long getStaffId() {
    return staffId;
  }
  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }
  public String getStaffname() {
    return staffname;
  }
  public void setStaffname(String staffname) {
    this.staffname = staffname;
  }
  public long getStaffage() {
    return staffage;
  }
  public void setStaffage(long staffage) {
    this.staffage = staffage;
  }
  public String getStaffsex() {
    return staffsex;
  }
  public void setStaffsex(String staffsex) {
    this.staffsex = staffsex;
  }
  public String getEducationBackground() {
    return educationBackground;
  }
  public void setEducationBackground(String educationBackground) {
    this.educationBackground = educationBackground;
  }
  public String getDuty() {
    return duty;
  }
  public void setDuty(String duty) {
    this.duty = duty;
  }
  public String getIdcard() {
    return idcard;
  }
  public void setIdcard(String idcard) {
    this.idcard = idcard;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getPhonenumber() {
    return phonenumber;
  }
  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  @Override
  public String toString() {
    return "StaffInformation{" +
            "staffId=" + staffId +
            ", staffname='" + staffname + '\'' +
            ", staffage=" + staffage +
            ", staffsex='" + staffsex + '\'' +
            ", educationBackground='" + educationBackground + '\'' +
            ", duty='" + duty + '\'' +
            ", idcard='" + idcard + '\'' +
            ", address='" + address + '\'' +
            ", phonenumber='" + phonenumber + '\'' +
            '}';
  }
}
