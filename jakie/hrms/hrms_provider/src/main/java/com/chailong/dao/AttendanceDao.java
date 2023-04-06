package com.chailong.dao;
import com.chailong.pojo.attendence;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceDao {
    List<attendence> attendence();
    public int attendancecount();
    public List<attendence> attendancelist(int currentpage);
    List<attendence> getattbydate(@Param("attdate") Date attdate);
    public void addnewattendaceInformation(@Param("attendanceinfo") attendence attendanceinfo);
    public void updateattinfo(@Param("info1")String info1,@Param("info2")String info2,@Param("info3")String info3);
    public void updateattinfo2(@Param("info1")String info1,@Param("info2")String info2,@Param("info3")String info3);
    public int getabsencebyID(@Param("staffId") int staffId);
    public attendence selectattbyid(@Param("staffId") int staffId,@Param("attdate")String attdate);
}
