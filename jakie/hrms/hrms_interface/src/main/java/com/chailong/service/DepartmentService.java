package com.chailong.service;

import com.chailong.pojo.Department;
import com.chailong.pojo.staff_and_departmentinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    public List<Department> getdepartmentinfo();
    public List<staff_and_departmentinfo>  pageinfo6();
    public Department getheaderinfo(int deptid,String staffoffice);
    public void deupdate(int deptid, int staffid, String staffoffice);
    public void adddeInformation( Department deinfo);
}
