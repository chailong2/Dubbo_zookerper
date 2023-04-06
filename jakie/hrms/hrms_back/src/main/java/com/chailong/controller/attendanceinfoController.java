package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.attendence;
import com.chailong.pojo.page;
import com.chailong.service.AttendanceService;
import com.chailong.service.StaffService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/atendance")
public class attendanceinfoController {
    @Reference//查找服务
    private AttendanceService attendanceService;
    @Reference//查找服务
    private StaffService staffService;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam(value="pn",defaultValue="1")Integer pn){         //该方法用于实现分页查询
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数2：每页显示数据的条数
        page mypageinfo=attendanceService.pagelife3(pn);
        System.out.println("chailong"+mypageinfo.getAttendences());
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/updateattinfo")
    @ResponseBody
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public String updateattinfo(@RequestParam("info1")String info1,@RequestParam("info2")String info2,@RequestParam("info3")String info3){
        attendanceService.updateattinfo(info1,info2,info3);
        return info2;
    }
    @RequestMapping("/findstaffbydate")
    @ResponseBody
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Map<String, Object> findstaffbydate(Date attdate){
        page mypageinfo=attendanceService.pagelife4(1,attdate);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/fixattendanceinfo")
    @ResponseBody
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Map<String, Object> fixattendanceinfo(Date attdate){
        List<attendence> test=new ArrayList<>();
        test=attendanceService.getattbydate(attdate);
        List<StaffInformation> staffInformationList = new ArrayList<>();
        staffInformationList = staffService.selectALlstaff();
        List<attendence> attendenceList = new ArrayList<>();
        if(test.size()==0) {   //当今日的考勤信息没有生成了
            int i = 0;
            for (StaffInformation staffInformation : staffInformationList) {
                i++;
                attendence att = new attendence();      //新建一条考勤记录
                att.setAttendanceId(i);
                att.setAttendancetime(attdate);
                att.setStaffInformation(staffInformation);
                att.setAttendancetype("未操作");
                attendenceList.add(att);
            }
            for (attendence myattendence : attendenceList) {
                attendanceService.addnewattendaceInformation(myattendence);
            }
        }
        else  //今日考勤信息没有生成
        {
            attendenceList=test;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("attendaceinfo", attendenceList);
        return map;
    }


}
