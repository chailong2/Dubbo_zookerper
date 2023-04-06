package com.chailong.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class attendence implements Serializable {
    private int attendanceId;
    private String attendancetype;
    private Date attendancetime;
    private StaffInformation staffInformation;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getAttendancetype() {
        return attendancetype;
    }

    public void setAttendancetype(String attendancetype) {
        this.attendancetype = attendancetype;
    }

    public Date getAttendancetime() {
        return attendancetime;
    }

    public void setAttendancetime(Date attendancetime) {
        this.attendancetime = attendancetime;
    }

    public StaffInformation getStaffInformation() {
        return staffInformation;
    }

    public void setStaffInformation(StaffInformation staffInformation) {
        this.staffInformation = staffInformation;
    }

    @Override
    public String toString() {
        return "attendence{" +
                "attendanceId=" + attendanceId +
                ", attendancetype='" + attendancetype + '\'' +
                ", attendancetime=" + attendancetime +
                ", staffInformation=" + staffInformation +
                '}';
    }
}
