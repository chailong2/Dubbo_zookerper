package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.AttendanceDao;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.attendence;
import com.chailong.pojo.page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    @Override
    public List<attendence> attendence() {
        return attendanceDao.attendence();
    }

    @Override
    public page pagelife3(int pagenumber) {
        page mypage=new page();
        int count=attendanceDao.attendancecount();   //获得总的记录条数
        mypage.setCount(count);      //总的数据条数
        System.out.println("count"+count);
        mypage.setCurrentPage(pagenumber); //设置当前页数
        int totalpagecount=0;
        if(count<=6)
            totalpagecount=1;
        else {
            if(count%6==0)
                totalpagecount = count / 6;
            else
                totalpagecount = count / 6+1;
        }
        mypage.setTotalPage(totalpagecount);
        mypage.setAttendences(attendanceDao.attendancelist((pagenumber-1)*6));  //记录分页数据
        System.out.println(attendanceDao.attendancelist((pagenumber-1)*6));
        if(mypage.getCurrentPage()==mypage.getTotalPage())
        {
            mypage.setHasNextPage(false);
        }
        else{
            mypage.setHasNextPage(true);
        }
        if(mypage.getCurrentPage()==1)
        {
            mypage.setHasPreviousPage(false);
        }
        else{
            mypage.setHasPreviousPage(true);
        }
        List<Integer> jakie=new ArrayList<>();
        for(int i=0;i<mypage.getTotalPage();i++)
        {
            jakie.add(i+1);
        }
        mypage.setTotalPagelist(jakie);
        return  mypage;
    }

    @Override
    public page pagelife4(int pagenumber, Date attdate) {
        page mypage=new page();
        List<attendence> list=new ArrayList<>();
        list=attendanceDao.getattbydate(attdate);
        int count=list.size();
        mypage.setCount(count);      //总的数据条数
        mypage.setAttendences(list);
        if(count==0)
        {
            mypage.setCurrentPage(0);
            int totalpagecount=0;
            mypage.setTotalPage(0);
        }
        else{
            int totalpagecount=0;
            mypage.setCurrentPage(pagenumber); //设置当前页数
            totalpagecount = 1;
            mypage.setTotalPage(totalpagecount);
            mypage.setHasNextPage(false);
            mypage.setHasPreviousPage(false);
            List<Integer> jakie=new ArrayList<>();
            for(int i=0;i<mypage.getTotalPage();i++)
            {
                jakie.add(i+1);
            }
            mypage.setTotalPagelist(jakie);
        }
        return  mypage;
    }

    @Override
    public void addnewattendaceInformation(attendence attendanceinfo) {
        attendanceDao.addnewattendaceInformation(attendanceinfo);
    }

    @Override
    public List<attendence> getattbydate(Date attdate) {
        return attendanceDao.getattbydate(attdate);
    }

    @Override
    public void updateattinfo(String info1, String info2, String info3) {
        attendanceDao.updateattinfo(info1, info2,info3);
    }

    @Override
    public void updateattinfo2(String info1, String info2, String info3) {
        attendanceDao.updateattinfo2(info1,info2,info3);
    }

    @Override
    public int getabsencebyID(int staffId) {
        return attendanceDao.getabsencebyID(staffId);
    }

    @Override
    public attendence selectattbyid(int staffId, String attdate) {
        return attendanceDao.selectattbyid(staffId,attdate);
    }
}
