package com.chailong.dao;
import com.chailong.pojo.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ApplyDao {
    Apply getApplyinfobyaccount(@Param("account")String account);
    void addnewapplyInformation(@Param("applyinfo")Apply applyinfo);
    List<Apply> selectbystatue();
    void deletebyid(@Param("account")String account);
    void updateapply(@Param("applystatue")String applystatue,@Param("account") String account);
}
