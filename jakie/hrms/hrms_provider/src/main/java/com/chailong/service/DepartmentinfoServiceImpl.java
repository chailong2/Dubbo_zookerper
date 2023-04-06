package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.DepartmentDao;
import com.chailong.dao.DepartmentinfoDao;
import com.chailong.pojo.DepartmentInfo;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class DepartmentinfoServiceImpl implements DepartmentinfoService {
    @Autowired
    DepartmentinfoDao departmentinfoDao;
    @Override
    public DepartmentInfo selectdepartmentByname(String dename) {
        return departmentinfoDao.selectdepartmentByname(dename);
    }
}
