package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.page;
import com.chailong.service.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

//员工信息管理
@RestController
@RequestMapping("/employee")
public class StaffinfoController {
    @Reference//查找服务
    private StaffService staffService;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam(value="pn",defaultValue="1")Integer pn){         //该方法用于实现分页查询
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数2：每页显示数据的条数
        page mypageinfo=staffService.pagelife(pn);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> staffinfoupdate(StaffInformation staffInformation){
        staffService.staffinfoupdate(staffInformation);   //更新员工的信息
        page mypageinfo=staffService.pagelife(1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> deletestaffinfo(@RequestParam(value="staffid")Integer staffid){
        System.out.println(staffid);
        staffService.deletestaffinfo(staffid);
        page mypageinfo=staffService.pagelife(1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo2", mypageinfo);
        return map;
    }
    @RequestMapping("/findstaffbyid")
    @ResponseBody
    public Map<String, Object> findstaffbyid(@RequestParam(value="staffid")Integer staffid){
        page mypageinfo=staffService.pagelife2(1,staffid);
        System.out.println(mypageinfo.getStaffInformations());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/addnewstaff")
    @ResponseBody
    public String addnewstaffInformation(StaffInformation staffInformation)
    {
        System.out.println(staffInformation);
        staffService.addnewstaffInformation(staffInformation);
        return "success";
    }
}
