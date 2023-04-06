package com.chailong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.*;
import com.chailong.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/theapply")
public class applyController {
    @Reference
    private ApplyService applyService;
    @Reference
    private StaffService staffService;
    @Reference
    private SalaryService salaryService;
    @Reference
    private DepartmentService departmentService;
    @Reference
    private DepartmentinfoService departmentinfoService;
    @RequestMapping("/getAllapplyinfo")
    @ResponseBody
        public Map<String,Object> getAllapplyinfo()
        {
            List<Apply> applyList=applyService.selectbystatue();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("applyinfo", applyList);
            return  map;
    }
    @RequestMapping("/refuseapply")
    @ResponseBody
    public Map<String,Object> refuseapply(@Param("account") String account)
    {
        String m="审核不通过";
        applyService.updateapply(m,account);
        List<Apply> applyList=applyService.selectbystatue();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("applyinfo", applyList);
        return map;
    }
    @RequestMapping("/passapply")
    @ResponseBody
    public Map<String,Object> passapply(@Param("account") String account)
    {
        String m="审核通过";
        applyService.updateapply(m,account);
        Apply apply=applyService.getApplyinfobyaccount(account);
        StaffInformation staffInformation=new StaffInformation();
        staffInformation.setStaffname(apply.getApplyname());
        staffInformation.setStaffsex(apply.getApplysex());
        staffInformation.setStaffage(apply.getApplyage());
        staffInformation.setEducationBackground(apply.getApplyeducation());
        staffInformation.setAddress(apply.getApplyaddress());
        staffInformation.setPhonenumber(apply.getApplyphonenumber());
        staffInformation.setIdcard(apply.getApplyidcard());
        staffInformation.setDuty("未定");
        staffService.addnewstaffInformation(staffInformation);
        List<Apply> applyList=applyService.selectbystatue();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("applyinfo", applyList);
        return map;
    }

}
