package com.chailong.dao;
import com.chailong.pojo.StaffInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface StaffDao {
    public List<StaffInformation> stafflist(int currentpage);
    public List<StaffInformation> selectALlstaff();
    public StaffInformation staffinfo(int id);
    public int staffcount();
    public void updateduty(@Param("staffid") int  staffid,@Param("duty")String duty);
    public void staffinfoupdate(@Param("staffInformation") StaffInformation staffInformation);  //更新员工的信息
    public void deletestaffinfo(@Param("staffid")Integer staffid);    //删除指定的员工信息
    public StaffInformation findstaff(@Param("findstaffbyid")Integer findstaffbyid);
    public void addnewstaffInformation(@Param("staffInformation") StaffInformation staffInformation);//插入新的员工信息
    public List<StaffInformation> selectStaffbyduty();
}
