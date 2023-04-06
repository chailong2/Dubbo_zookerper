package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.DepartmentDao;
import com.chailong.dao.DepartmentinfoDao;
import com.chailong.dao.StaffDao;
import com.chailong.pojo.Department;
import com.chailong.pojo.DepartmentInfo;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.staff_and_departmentinfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentServiceImpl  implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DepartmentinfoDao departmentinfoDao;
    @Autowired
    private StaffDao staffDao;
    @Override
    public List<Department> getdepartmentinfo() {
        return departmentDao.getdepartmentinfo();
    }

    @Override
    public List<staff_and_departmentinfo> pageinfo6() {
        List<staff_and_departmentinfo> mypage=new ArrayList<>();
        List<DepartmentInfo> departmentInfos=departmentinfoDao.selectAlldepartment();//获得所有部门
        List<Department> departments=departmentDao.getdepartmentinfo(); //获得部门信息
        for (DepartmentInfo departmentInfo : departmentInfos) {
            staff_and_departmentinfo info=new staff_and_departmentinfo();
            List<StaffInformation> staffInformationss=new ArrayList<>();
            info.setDepartment(departmentInfo);
            for (Department department : departments) {
                if(department.getDeptid()==departmentInfo.getDetid()&&department.getStaffoffice().equals("部门负责人"))  //部门匹配
                {
                            info.setHeader(staffDao.findstaff(department.getStaffid()));
                }
                if(department.getDeptid()==departmentInfo.getDetid()&&department.getStaffoffice().equals("员工"))  //部门匹配
                {
                  staffInformationss.add(staffDao.findstaff(department.getStaffid()));
                }
            }
            info.setStaffInformationList(staffInformationss);
            mypage.add(info);
        }
        System.out.println(mypage);
        return mypage;
    }

    @Override
    public Department getheaderinfo(int deptid, String staffoffice) {
        return departmentDao.getheaderinfo(deptid,staffoffice);
    }

    @Override
    public void deupdate(int deptid, int staffid, String staffoffice) {
        departmentDao.deupdate(deptid,staffid,staffoffice);
    }

    @Override
    public void adddeInformation(Department deinfo) {
        departmentDao.adddeInformation(deinfo);
    }
}
