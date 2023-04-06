package com.chailong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Administer;
import com.chailong.pojo.Apply;
import com.chailong.service.AdministerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Reference
    private AdministerService administerService;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> adminlist()
    {
        List<Administer>administer=administerService.getalladmin();
        System.out.println(administer);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("admininfo", administer);
        return  map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Administer administer)
    {
        administerService.updateadmin(administer);
        List<Administer>administers=administerService.getalladmin();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("admininfo", administers);
        return  map;
    }
    @RequestMapping("/addnewadmin")
    @ResponseBody
    public String addnewadmin(Administer administer)
    {
        Administer administer1=administerService.getadmininfobyaccount(administer.getAccount());
        System.out.println(administer1);
        if(administer1!=null)
            return "false";
        else
            administerService.addnewadminInformation(administer);
        return "true" ;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(@Param("account") String  account)
    {
        administerService.deleteadmininfo(account);
        List<Administer>administers=administerService.getalladmin();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("admininfo", administers);
        return  map;
    }
}
