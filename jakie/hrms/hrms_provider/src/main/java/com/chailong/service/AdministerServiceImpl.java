package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.AdministerDao;
import com.chailong.pojo.Administer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AdministerServiceImpl implements AdministerService {
    @Autowired
    private AdministerDao administerDao;
    @Override
    public Administer getadmininfobyaccount(String account) {
        return administerDao.getadmininfobyaccount(account);
    }

    @Override
    public void updateadmin(Administer admin) {
        administerDao.updateadmin(admin);
    }

    @Override
    public List<Administer> getalladmin() {
        return administerDao.getalladmin();
    }

    @Override
    public void addnewadminInformation(Administer admininfo) {
        administerDao.addnewadminInformation(admininfo);
    }

    @Override
    public void deleteadmininfo(String account) {
        administerDao.deleteadmininfo(account);
    }
}
