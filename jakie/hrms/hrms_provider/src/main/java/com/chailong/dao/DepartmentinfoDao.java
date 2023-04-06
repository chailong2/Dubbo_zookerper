package com.chailong.dao;

import com.chailong.pojo.DepartmentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentinfoDao {
    List<DepartmentInfo> selectAlldepartment();
    DepartmentInfo selectdepartmentByname(@Param("dename")String dename);
}
