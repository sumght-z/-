package com.stx.Project_1;

import java.util.ArrayList;
import java.util.Scanner;

public class First_window {

    Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void first_window(){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("----------享车系统-----------");
        System.out.println("|1.登录               2.注册|");
        System.out.println("|3.关于               4.退出|");
        System.out.println("-----------------------------");
        n=sc.nextInt();
        switch (n)
        {
            case 1:dao.login();
                break;
            case 2:dao.register();
                break;
            case 3:System.out.println("管理员账户内置为admin，普通用户需要自行注册或者管理员添加\n管理员拥有查看所有用户和车辆的权限，并可以随意添加和删除用户与车辆\n普通会员可以随意租借和归还车辆，并且拥有完整的金钱系统\n普通用户只能查看到自己的租借车辆\n作者：sumght 2019年10月2日");
            dao.back1();
                break;
            case 4:System.exit(-1);//执行退出
                break;
        }
    }
}
