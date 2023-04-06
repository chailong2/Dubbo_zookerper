package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.TouristloginDao;
import com.chailong.pojo.Touristlogin;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TouristloginServiceImpl implements TouristloginService {
    @Autowired
    private TouristloginDao touristloginDao;
    @Override
    public int gettouristinfobyaccount(String account) {
        return touristloginDao.gettouristinfobyaccount(account);
    }

    @Override
    public void addnewtouristlofinfo(String account, String password) {
        touristloginDao.addnewtouristlofinfo(account,password);
    }

    @Override
    public Touristlogin vertifytourist(String account, String password) {
        return touristloginDao.vertifytourist(account,password);
    }
}
