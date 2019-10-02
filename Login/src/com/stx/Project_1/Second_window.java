package com.stx.Project_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Second_window {
    Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    Scanner sc=new Scanner(System.in);
    public void second_window(){

switch (dao.people_list.get(dao.i).getQuanxian())
{

    //普通用户
    case 1:System.out.println("-------------------业务界面--------------------");
        System.out.println("|              尊敬的会员"+dao.people_list.get(dao.i).getUsername()+"欢迎您            |");
        System.out.println("|1.查看所有车辆并租用                 2.查看余额|");
        System.out.println("|3.查看自己的租用情况                 4.充值金钱|");
        System.out.println("|5.归还车辆                           6.注销用户|");
        System.out.println("-----------------------------------------------");
        switch (sc.nextInt()){
            case 1:dao.selectcar();
            dao.zujie();
                break;
            case 2:System.out.println("你当前余额为"+dao.people_list.get(dao.i).getMoney());
            dao.back2();
                break;
            case 3:dao.select_myself();
                break;
            case 4:
            System.out.print("请输入你充值的金额:");
            dao.people_list.get(dao.i).setMoney(dao.people_list.get(dao.i).getMoney()+sc.nextInt());
                System.out.println("充值成功");
                System.out.println("你当前余额为"+dao.people_list.get(dao.i).getMoney());
                dao.back2();
                break;
            case 5:dao.return_car();
                break;
            case 6:dao.first_window.first_window();
                break;

        }
        break;
    //管理员
    case 2:System.out.println("-------------------业务界面--------------------");
        System.out.println("|            尊敬的管理员"+dao.people_list.get(dao.i).getUsername()+"欢迎您            |");
        System.out.println("|1.查看所有车辆                2.查看所有用户列表|");
        System.out.println("|3.添加更多车辆                       4.添加用户|");
        System.out.println("|5.删除车辆                           6.删除用户|");
        System.out.println("|7.提升用户权限                           8.注销|");
        System.out.println("-----------------------------------------------");
        switch (sc.nextInt()){
        case 1:dao.selectcar_admin();
            break;
        case 2:dao.selectuser_admin();
            break;
        case 3:dao.addcar_admin();
            break;
        case 4:dao.adduser_admin();
            break;
        case 5:dao.delcar_admin();
            break;
        case 6:dao.deluser_admin();
            break;
        case 7:dao.upuser_admin();
            break;
        case 8:
            dao.first_window.first_window();
            break;

    }
}
    }
}
