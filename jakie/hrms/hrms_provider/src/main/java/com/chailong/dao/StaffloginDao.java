package com.chailong.dao;

import com.chailong.pojo.Stafflogin;
import org.apache.ibatis.annotations.Param;

public interface StaffloginDao {
    int getstaffinfobyaccount(@Param("account") String account);
    void addnewstafflofinfo(@Param("account") String account,@Param("password") String password,@Param("staffid") int staffid);
    Stafflogin vertifystaff(@Param("account") String account,@Param("password") String password);
    Stafflogin getstaffbyid(@Param("staffid") int staffid);
}
