package com.chailong.dao;

import com.chailong.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    public List<Department> getdepartmentinfo();
    public Department getheaderinfo(@Param("deptid") int deptid, @Param("staffoffice")String staffoffice);
    public void deupdate(@Param("deptid")int deptid, @Param("staffid")int staffid, @Param("staffoffice")String staffoffice);
    public void adddeInformation(@Param("deinfo") Department deinfo);
}
