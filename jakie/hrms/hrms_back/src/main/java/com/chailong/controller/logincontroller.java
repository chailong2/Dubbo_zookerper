package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Administer;
import com.chailong.service.AdministerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/gologin")
public class logincontroller {
    @Reference
    private AdministerService administerService;
    @RequestMapping("/adminlogin")
    public String login(HttpSession session, @Param("account") String account,@Param("password") String password){
        Administer administer=administerService.getadmininfobyaccount(account);
        if(administer==null||administer.getPassword().equals(password)==false)
            return "false";
        session.setAttribute("adminname", administer.getAdministername());
        session.setAttribute("adminacount", administer.getAccount());
        session.setAttribute("adminpassword", administer.getPassword());
        return  "true";
    }
    @RequestMapping("/adminupdate")
    public String adminupdate(Administer administer){
        System.out.println(administer);
        administerService.updateadmin(administer);
        return  "true";
    }
    @RequestMapping("/adminlogout")
    public String adminlogout(HttpSession session){
        session.removeAttribute("adminname");
        session.removeAttribute("adminacount");
        session.removeAttribute("adminpassword");
        return "sucess";
    }
}
