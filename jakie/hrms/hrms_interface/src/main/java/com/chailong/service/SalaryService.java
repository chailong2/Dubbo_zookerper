package com.chailong.service;

import com.chailong.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryService {
    List<Salary> getsalarybydate(int salaryyear, int salarymouth);
    void addnewSalaryInformation(Salary salaryinfo);
    void updateSalaryinfo(String salarystatue,int salaryyear,int salarymouth,int salaryId);
    List<Salary> getallsalaryinfo();
    Salary getallsalaryinfowithid(int salaryyear,int salarymouth,int staffid);
    void deletesalaryinfo(int salaryyear,int salarymouth);
}
