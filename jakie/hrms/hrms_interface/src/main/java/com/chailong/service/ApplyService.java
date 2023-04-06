package com.chailong.service;

import com.chailong.pojo.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyService {
    Apply getApplyinfobyaccount(String account);
    public void addnewapplyInformation( Apply applyinfo);
    List<Apply> selectbystatue();
    void deletebyid(String account);
    void updateapply(String applystatue, String account);

}
