package com.yunbocheng;

public class Manager {
    // 定义一个账号
    private String account;
    // 定义一个密码
    private String password;


    public Manager() {

    }

    public Manager(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

