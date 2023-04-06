package com.chailong.pojo;

import java.io.Serializable;
import java.util.List;

public class page implements Serializable {
    //数据总数
    private Integer count;
    //总页数
    private Integer totalPage;
    //当前页数
    private Integer currentPage;
    //数据库中limit的参数，从第几条开始取
    //用来存储数据
    private List<StaffInformation>staffInformations;

    private List<attendence> attendences;
    //是否还有前页
    private boolean hasPreviousPage;
    //是否还有后页
    private boolean hasNextPage;
    //页面导航
    private  List<Integer> totalPagelist;


    public List<Integer> getTotalPagelist() {
        return totalPagelist;
    }

    public void setTotalPagelist(List<Integer> totalPagelist) {
        this.totalPagelist = totalPagelist;
    }

    public page() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<StaffInformation> getStaffInformations() {
        return staffInformations;
    }

    public void setStaffInformations(List<StaffInformation> staffInformations) {
        this.staffInformations = staffInformations;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<attendence> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<attendence> attendences) {
        this.attendences = attendences;
    }
}


