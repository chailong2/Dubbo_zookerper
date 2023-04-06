package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.SalaryDao;
import com.chailong.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService{
    @Autowired
    private SalaryDao salaryDao;
    @Override
    public List<Salary> getsalarybydate(int salaryyear, int salarymouth) {
        return salaryDao.getsalarybydate(salaryyear,salarymouth);
    }

    @Override
    public void addnewSalaryInformation(Salary salaryinfo) {
        salaryDao.addnewSalaryInformation(salaryinfo);
    }

    @Override
    public void updateSalaryinfo(String salarystatue, int salaryyear, int salarymouth, int salaryId) {
        salaryDao.updateSalaryinfo(salarystatue,salaryyear,salarymouth,salaryId);
    }

    @Override
    public List<Salary> getallsalaryinfo() {
        return salaryDao.getallsalaryinfo();
    }

    @Override
    public Salary getallsalaryinfowithid(int salaryyear, int salarymouth, int staffid) {
        return salaryDao.getallsalaryinfowithid(salaryyear,salarymouth,staffid);
    }

    @Override
    public void deletesalaryinfo(int salaryyear, int salarymouth) {
        salaryDao.deletesalaryinfo(salaryyear,salarymouth);
    }
}
