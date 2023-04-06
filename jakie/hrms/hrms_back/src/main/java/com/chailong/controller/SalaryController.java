package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Salary;
import com.chailong.pojo.StaffInformation;
import com.chailong.service.AttendanceService;
import com.chailong.service.SalaryService;
import com.chailong.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Reference//查找服务
    private AttendanceService attendanceService;
    @Reference//查找服务
    private SalaryService salaryService;
    @Reference//查找服务
    private StaffService staffService;
    @RequestMapping("/fixsalaryinfo")
    @ResponseBody
    public Map<String, Object> fixattendanceinfo(){
        Calendar now=Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        int mouth=now.get(Calendar.MONTH)+1;
        salaryService.deletesalaryinfo(year,mouth);
        List<StaffInformation> staffInformationList = new ArrayList<>();
        staffInformationList = staffService.selectALlstaff();
        List<Salary> salaries1=new ArrayList<>();
        for (StaffInformation staffInformation : staffInformationList) {
            Salary att = new Salary();      //新建一条考勤记录
            att.setSalarymouth(mouth);
            att.setSalaryyear(year);
            att.setStaffInformation(staffInformation);
            if(att.getStaffInformation().getDuty()==null)
                att.getStaffInformation().setDuty("无");
            att.setSalarystatue("未发放");
            if(att.getStaffInformation().getDuty().equals("部门负责人"))
            {
                att.setSalarynum(12000);
            }
            else {
                att.setSalarynum(8000);
            }
             salaries1.add(att);
            }
        for (Salary salary : salaries1) {
            salaryService.addnewSalaryInformation(salary);
        }
        salaries1=salaryService.getallsalaryinfo();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Salaryinfo", salaries1);
        return map;
    }
    @RequestMapping("/updatesalaryinfo")
    @ResponseBody
    public String updatesalaryinfo(@Param("info1")int info1,@Param("info2") String info2,@Param("info3") int info3,@Param("info4") int info4)
    {
        salaryService.updateSalaryinfo(info2,info3,info4,info1);
        return "nihao";
    }
}
