package com.chailong.pojo;

import java.io.Serializable;
import java.util.List;

public class staff_and_departmentinfo implements Serializable {
    private DepartmentInfo department;  //部门信息
    private List<StaffInformation> staffInformationList;   //部门员工
    private StaffInformation header; //部门负责人

    public DepartmentInfo getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentInfo department) {
        this.department = department;
    }

    public List<StaffInformation> getStaffInformationList() {
        return staffInformationList;
    }

    public void setStaffInformationList(List<StaffInformation> staffInformationList) {
        this.staffInformationList = staffInformationList;
    }

    public StaffInformation getHeader() {
        return header;
    }

    public void setHeader(StaffInformation header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "staff_and_departmentinfo{" +
                "department=" + department +
                ", staffInformationList=" + staffInformationList +
                ", header=" + header +
                '}';
    }
}
