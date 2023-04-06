package com.chailong.service;

import com.chailong.pojo.Touristlogin;
import org.apache.ibatis.annotations.Param;

public interface TouristloginService {
    int gettouristinfobyaccount(String account);
    void addnewtouristlofinfo( String account, String password);
    Touristlogin vertifytourist(String account, String password);
}
