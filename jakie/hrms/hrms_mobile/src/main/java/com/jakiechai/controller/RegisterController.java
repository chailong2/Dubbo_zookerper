package com.jakiechai.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.service.StaffService;
import com.chailong.service.StafflogService;
import com.chailong.service.TouristloginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Reference
    private TouristloginService touristloginService;
    @Reference
    private StaffService staffService;
    @Reference
    private StafflogService stafflogService;
    @RequestMapping("/touristregister")
    @ResponseBody
    public String  touristlogin(@Param("account") String account,@Param("password") String password)
    {
        int count=touristloginService.gettouristinfobyaccount(account);
        if(count!=0)
            return "该账号重复，请重新注册！";
        touristloginService.addnewtouristlofinfo(account,password);
        return "success";
    }
    @RequestMapping("/staffregister")
    @ResponseBody
    public String  stafflogin(@Param("account") String account,@Param("password") String password,@Param("staffid") int staffid)
    {
        int count= stafflogService.getstaffinfobyaccount(account);
        if(count!=0)
            return "该账号重复，请重新注册！";
        if(staffService.findstaff(staffid)==null)
        {
            return "该员工不存在，请重新注册！";
        }
        if(stafflogService.getstaffbyid(staffid)!=null)
            return "你已经注册，请勿重复注册!";
        stafflogService.addnewstafflofinfo(account,password,staffid);
        return "success";
    }
}
