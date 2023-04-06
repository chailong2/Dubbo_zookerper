package com.chailong.dao;

import com.chailong.pojo.Touristlogin;
import org.apache.ibatis.annotations.Param;

public interface TouristloginDao {
    int gettouristinfobyaccount(@Param("account") String account);
    void addnewtouristlofinfo(@Param("account") String account,@Param("password") String password);
    Touristlogin vertifytourist(@Param("account") String account,@Param("password") String password);
}
