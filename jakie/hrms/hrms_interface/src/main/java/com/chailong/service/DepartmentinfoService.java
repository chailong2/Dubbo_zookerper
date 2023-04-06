package com.chailong.service;

import com.chailong.pojo.DepartmentInfo;
import org.apache.ibatis.annotations.Param;

public interface DepartmentinfoService {
    DepartmentInfo selectdepartmentByname(String dename);
}
