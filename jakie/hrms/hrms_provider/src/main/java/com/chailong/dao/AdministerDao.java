package com.chailong.dao;

import com.chailong.pojo.Administer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministerDao {
    public Administer getadmininfobyaccount(@Param("account")String account);
    public void updateadmin(@Param("admin")Administer admin);
    public List<Administer> getalladmin();
    public void addnewadminInformation(@Param("admininfo")Administer admininfo);
    public void deleteadmininfo(@Param("account")String account );
}
