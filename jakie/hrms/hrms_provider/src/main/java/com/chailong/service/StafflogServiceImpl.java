package com.chailong.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.StaffloginDao;
import com.chailong.pojo.Stafflogin;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StafflogServiceImpl implements StafflogService{
    @Autowired
    private StaffloginDao staffloginDao;
    @Override
    public int getstaffinfobyaccount(String account) {
        return staffloginDao.getstaffinfobyaccount(account);
    }

    @Override
    public void addnewstafflofinfo(String account, String password, int staffid) {
        staffloginDao.addnewstafflofinfo(account,password,staffid);
    }

    @Override
    public Stafflogin vertifystaff(String account, String password) {
        return staffloginDao.vertifystaff(account,password);
    }

    @Override
    public Stafflogin getstaffbyid(int staffid) {
        return staffloginDao.getstaffbyid(staffid);
    }
}
