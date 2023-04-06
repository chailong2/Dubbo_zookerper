package com.chailong.service;

import com.chailong.pojo.Apply;
import com.chailong.pojo.attendence;
import com.chailong.pojo.page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    List<attendence> attendence();
    public page pagelife3(int pagenumber);
    public page pagelife4(int pagenumber,Date attdate);
    public void addnewattendaceInformation(attendence attendanceinfo);
    List<attendence> getattbydate(Date attdate);
    public void updateattinfo(String info1,String info2,String info3);
    public void updateattinfo2(String info1,String info2,String info3);
    public int getabsencebyID( int staffId);
    public attendence selectattbyid(int staffId,String attdate);

}
