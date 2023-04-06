package com.chailong.dao;

import com.chailong.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryDao {
    List<Salary> getsalarybydate(@Param("salaryyear") int salaryyear, @Param("salarymouth") int salarymouth);
    void addnewSalaryInformation(@Param("salaryinfo") Salary salaryinfo);
    void updateSalaryinfo(@Param("salarystatue")String salarystatue,@Param("salaryyear")int salaryyear,
                          @Param("salarymouth")int salarymouth,@Param("salaryId")int salaryId);
    List<Salary> getallsalaryinfo();
    Salary getallsalaryinfowithid(@Param("salaryyear") int salaryyear, @Param("salarymouth") int salarymouth,@Param("staffid") int staffid);
    void deletesalaryinfo(@Param("salaryyear") int salaryyear, @Param("salarymouth") int salarymouth);
}
