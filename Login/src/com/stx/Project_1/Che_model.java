package com.stx.Project_1;

public class Che_model {
String cheid;//车辆编号
int leixing;//车辆为自行车还是电动车
int user; //租借人编号
boolean have;//出租情况

    public String getCheid() {
        return cheid;
    }

    public void setCheid(String cheid) {
        this.cheid = cheid;
    }

    public int getLeixing() {
        return leixing;
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public boolean isHave() {
        return have;
    }

    public void setHave(boolean have) {
        this.have = have;
    }
}
