package com.chailong.service;

import com.chailong.pojo.Stafflogin;
import org.apache.ibatis.annotations.Param;

public interface StafflogService {
    int getstaffinfobyaccount(String account);
    void addnewstafflofinfo(String account,String password,int staffid);
    Stafflogin vertifystaff( String account,  String password);
    Stafflogin getstaffbyid(int staffid);
}
