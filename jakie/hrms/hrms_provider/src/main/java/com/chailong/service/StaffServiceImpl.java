package com.chailong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.dao.StaffDao;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.page;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    //注入dao对象
    @Autowired
    private StaffDao staffDao;

    @Override
    public List<StaffInformation> staffs(int currentpage) {
        return staffDao.stafflist(currentpage);
    }

    @Override
    public StaffInformation findstaff(int id) {
        return staffDao.findstaff(id);
    }

    @Override
    public int staffcount() {
        return staffDao.staffcount();
    }

    @Override
    public page pagelife(int pagenumber) {
        page mypage = new page();
        int count = staffDao.staffcount();   //获得总的记录条数
        mypage.setCount(count);      //总的数据条数
        mypage.setCurrentPage(pagenumber); //设置当前页数
        int totalpagecount = 0;
        if (count <= 6)
            totalpagecount = 1;
        else {
            if(count%6==0)
                totalpagecount = count / 6;
            else
                totalpagecount = count / 6+1;
        }
        mypage.setTotalPage(totalpagecount);
        mypage.setStaffInformations(staffDao.stafflist((pagenumber - 1) * 6));  //记录分页数据
        if (mypage.getCurrentPage() == mypage.getTotalPage()) {
            mypage.setHasNextPage(false);
        } else {
            mypage.setHasNextPage(true);
        }
        if (mypage.getCurrentPage() == 1) {
            mypage.setHasPreviousPage(false);
        } else {
            mypage.setHasPreviousPage(true);
        }
        List<Integer> jakie = new ArrayList<>();
        for (int i = 0; i < mypage.getTotalPage(); i++) {
            jakie.add(i + 1);
        }
        mypage.setTotalPagelist(jakie);
        return mypage;
    }

    @Override
    public void staffinfoupdate(StaffInformation staffInformation) {
        staffDao.staffinfoupdate(staffInformation);
    }

    @Override
    public void deletestaffinfo(Integer staffid) {
        staffDao.deletestaffinfo(staffid);
    }

    @Override
    public page pagelife2(int pagenumber, int staffid) {
        page mypage = new page();
        int count = 1;   //获得总的记录条数
        mypage.setCount(count);      //总的数据条数
        mypage.setCurrentPage(pagenumber); //设置当前页数
        int totalpagecount = 1;
        mypage.setTotalPage(totalpagecount);
        List<StaffInformation> list = new ArrayList<>();
        StaffInformation info = staffDao.findstaff(staffid);
        list.add(info);
        mypage.setStaffInformations(list);
        mypage.setHasNextPage(false);
        mypage.setHasPreviousPage(false);
        List<Integer> jakie = new ArrayList<>();
        jakie.add(1);
        mypage.setTotalPagelist(jakie);
        return mypage;
    }

    @Override
    public void addnewstaffInformation(StaffInformation staffInformation) {
        staffDao.addnewstaffInformation(staffInformation);
    }

    @Override
    public List<StaffInformation> selectALlstaff() {
        return staffDao.selectALlstaff();
    }

    @Override
    public void updateduty(int staffid, String duty) {
        staffDao.updateduty(staffid,duty);
    }

    @Override
    public List<StaffInformation> selectStaffbyduty() {
        return staffDao.selectStaffbyduty();
    }

}
