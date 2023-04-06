package com.chailong.service;

import com.chailong.pojo.Administer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministerService {
    public Administer getadmininfobyaccount(String account);
    public void updateadmin(Administer admin);
    public List<Administer> getalladmin();
    public void addnewadminInformation(Administer admininfo);
    public void deleteadmininfo(String account );
}
