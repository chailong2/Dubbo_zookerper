package com.jakiechai.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Salary;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.attendence;
import com.chailong.service.AttendanceService;
import com.chailong.service.SalaryService;
import com.chailong.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/self")
public class staffselfinfoController {
    @Reference
    private StaffService staffService;
    @Reference
    private SalaryService salaryService;
    @Reference
    private AttendanceService attendanceService;
    @RequestMapping("/selfinfo")
    @ResponseBody
    public StaffInformation selfinfo(@Param("staffid") int staffid){
        return staffService.findstaff(staffid);
    }
    @RequestMapping("/selfinfoupdate")
    @ResponseBody
    public StaffInformation selfinfoupdate(StaffInformation staffInformation)
    {
            staffService.staffinfoupdate(staffInformation);
            return staffInformation;
    }
    @RequestMapping("/selfsalary")
    @ResponseBody
    public Salary selfsalary(@Param("staffid") int staffid)
    {
        Calendar now=Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        int mouth=now.get(Calendar.MONTH)+1;
        Salary salary=salaryService.getallsalaryinfowithid(year,mouth,staffid);
        System.out.println(salary);
        return salary;
    }
    @RequestMapping("/signin")
    @ResponseBody
    public String signin(@Param("staffid") int staffid)
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result1 = sdf.format(date);
        System.out.println(result1);
        attendence myatt=attendanceService.selectattbyid(staffid,result1);
        System.out.println(myatt);
        if(myatt==null)
            return "此时不允许签到请待会再试一下";
        if(myatt.getAttendancetype().equals("在勤"))
            return "今日已经签到，请勿要重复签到";
        attendanceService.updateattinfo2(String.valueOf(staffid),result1,"在勤");
        return "签到成功";
    }
}
