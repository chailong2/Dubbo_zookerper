package com.jakiechai.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.chailong.pojo.Apply;
import com.chailong.pojo.StaffInformation;
import com.chailong.service.ApplyService;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;
@RestController
@RequestMapping("/tourist")
public class touristinfoController {
    @Reference
    private ApplyService applyService;
    @RequestMapping("/applyinfo")
    @ResponseBody
    public String  applyinfo(Apply apply) throws UnsupportedEncodingException {
        Apply apply1=applyService.getApplyinfobyaccount(apply.getAccount());
        if(apply1!=null) {
            if(apply1.getApplystatue().equals("审核通过"))
                return "请勿重复申请！";
            applyService.deletebyid(apply1.getAccount());
        }
        applyService.addnewapplyInformation(apply);
        return "申请成功";
    }
    @RequestMapping("/applyconse")
    @ResponseBody
    public Apply  applyconse(@Param("account") String account)
    {

        return applyService.getApplyinfobyaccount(account);
    }
}
