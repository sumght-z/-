package com.stx.Project_1;

public class People_model {
    String username;//用户名
    String userpassword;//密码
    int quanxian;//权限等级
    int money;//金额

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(int quanxian) {
        this.quanxian = quanxian;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
