package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.*;
import com.chailong.service.AttendanceService;
import com.chailong.service.DepartmentService;
import com.chailong.service.DepartmentinfoService;
import com.chailong.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Reference//查找服务
    private DepartmentService departmentService;
    @Reference
    private DepartmentinfoService departmentinfoService;
    @Reference
    private StaffService staffService;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> getdepartmentinfo(){         //该方法用于实现分页查询
        List<staff_and_departmentinfo> mypageinfo=departmentService.pageinfo6();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/addnewemploy")
    @ResponseBody
    public Map<String, Object> addnewemploy(@Param("id")int id, @Param("department")String department){         //该方法用于实现分页查询

        System.out.println(id);
        System.out.println(department);
        DepartmentInfo departmentInfo=departmentinfoService.selectdepartmentByname(department);
        Department department2=new Department();
        department2.setStaffid(id);
        department2.setDeptid(departmentInfo.getDetid());
        department2.setStaffoffice("员工");
        departmentService.adddeInformation(department2);
        staffService.updateduty(id,"员工");
        List<staff_and_departmentinfo> mypageinfo=departmentService.pageinfo6();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }
    @RequestMapping("/deaddstaff")
    @ResponseBody
    public Map<String, Object> deaddstaff(){         //该方法用于实现分页查询
        List<StaffInformation> informations=staffService.selectStaffbyduty();
        Map<String, Object> map = new HashMap<String, Object>();
        if(informations==null)
        {
            String cons="无空闲员工";
            map.put("stafflist",cons);
            return  map;
        }
        map.put("stafflist", informations);
        return map;
    }
    @RequestMapping("/updatedeinfo")
    @ResponseBody
    public Map<String, Object> updatedeinfo(@RequestParam("info1")String info1,@RequestParam("info2")String info2,@RequestParam("info3")String info3){         //该方法用于实现分页查询
        System.out.println(info1);
        System.out.println(info2);
        System.out.println(info3);
        DepartmentInfo departmentInfo=departmentinfoService.selectdepartmentByname(info2);
        Department department=departmentService.getheaderinfo(departmentInfo.getDetid(),"部门负责人");
        staffService.updateduty(Integer.parseInt(info1),info3);  //更新用户信息表
        if(info3.equals("部门负责人"))   //部门负责人
        {
            if(department==null)
            {
                departmentService.deupdate(departmentInfo.getDetid(),Integer.parseInt(info1),"部门负责人");
            }
            else{
                departmentService.deupdate(departmentInfo.getDetid(),department.getStaffid(),"员工");
                staffService.updateduty(department.getStaffid(), "员工");
                departmentService.deupdate(departmentInfo.getDetid(),Integer.parseInt(info1),"部门负责人");
            }
        }
        else{
            departmentService.deupdate(departmentInfo.getDetid(),Integer.parseInt(info1),"员工");
        }
        List<staff_and_departmentinfo> mypageinfo=departmentService.pageinfo6();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageInfo", mypageinfo);
        return map;
    }

}
