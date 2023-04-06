package com.jakiechai.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Stafflogin;
import com.chailong.pojo.Touristlogin;
import com.chailong.service.StaffService;
import com.chailong.service.StafflogService;
import com.chailong.service.TouristloginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class loginController {
    @Reference
    private TouristloginService touristloginService;
    @Reference
    private StaffService staffService;
    @Reference
    private StafflogService stafflogService;
    @RequestMapping("/stafflogin")
    @ResponseBody
    public String  stafflogin(@Param("account") String account, @Param("password") String password, HttpSession session)
    {
        Stafflogin stafflogin=stafflogService.vertifystaff(account,password);
        if(stafflogin==null)
            return "账号或密码错误，请重新输入！";
        session.setAttribute("staff", stafflogin.getStaffInformation().getStaffId());
        return "success";
    }
    @RequestMapping("/passlogin")
    @ResponseBody
    public String  passlogin(@Param("account") String account, @Param("password") String password, HttpSession session)
    {
        Touristlogin touristlogin=touristloginService.vertifytourist(account,password);
        System.out.println(touristlogin);
        if(touristlogin==null)
            return "账号或密码错误，请重新输入！";
        session.setAttribute("tou", touristlogin.getAccount());
        return "success";
    }
}
