package com.chailong.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.ApplyDao;
import com.chailong.pojo.Apply;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ApplyServiceImpl  implements ApplyService{
    @Autowired
    private ApplyDao applyDao;
    @Override
    public Apply getApplyinfobyaccount(String account) {
        return applyDao.getApplyinfobyaccount(account);
    }

    @Override
    public void addnewapplyInformation(Apply applyinfo) {
        applyDao.addnewapplyInformation(applyinfo);
    }

    @Override
    public List<Apply> selectbystatue() {
        return applyDao.selectbystatue();
    }

    @Override
    public void deletebyid(String account) {
        applyDao.deletebyid(account);
    }

    @Override
    public void updateapply(String applystatue, String account) {
        applyDao.updateapply(applystatue,account);
    }
}
