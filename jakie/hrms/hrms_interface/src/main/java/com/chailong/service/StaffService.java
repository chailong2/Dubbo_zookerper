package com.chailong.service;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//服务接口
public interface StaffService {
    public List<StaffInformation> staffs(int currentpage);
    public StaffInformation findstaff(int id);
    public int staffcount();
    public page pagelife(int pagenumber);
    public void staffinfoupdate(StaffInformation staffInformation);
    public void deletestaffinfo(Integer staffid);
    public  page pagelife2(int pagenumber,int staffid);
    public void addnewstaffInformation( StaffInformation staffInformation);
    public List<StaffInformation> selectALlstaff();
    public void updateduty( int  staffid,String duty);
    public List<StaffInformation> selectStaffbyduty();
}
