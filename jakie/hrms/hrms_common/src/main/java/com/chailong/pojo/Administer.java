package com.chailong.pojo;

import java.io.Serializable;

public class Administer  implements Serializable {
    private String administername;
    private String account;
    private String password;


    public String getAdministername() {
        return administername;
    }

    public void setAdministername(String administername) {
        this.administername = administername;
    }

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

    @Override
    public String toString() {
        return "administer{" +
                ", administername='" + administername + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
