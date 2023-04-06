package com.chailong.pojo;

import java.io.Serializable;

public class Stafflogin implements Serializable {
    private String account;
    private String password;
    private StaffInformation staffInformation;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StaffInformation getStaffInformation() {
        return staffInformation;
    }

    public void setStaffInformation(StaffInformation staffInformation) {
        this.staffInformation = staffInformation;
    }

    @Override
    public String toString() {
        return "Stafflogin{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", staffInformation=" + staffInformation +
                '}';
    }
}
