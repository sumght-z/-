package com.stx.Project_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Dao {
    public int i;
    public int m;
    public int x;
    First_window first_window;

    public void setFirst_window(First_window first_window) {
        this.first_window = first_window;
    }
    Second_window second_window;

    public void setSecond_window(Second_window second_window) {
        this.second_window = second_window;
    }

    int n;
    Scanner sc=new Scanner(System.in);
    People_model peopleModel;
    ArrayList<People_model> people_list;
    Che_model che_model;
    ArrayList<Che_model> che_list;

    public void setPeople_list(ArrayList<People_model> people_list) {
        this.people_list = people_list;
    }

    public void setPeopleModel(People_model peopleModel) {
        this.peopleModel = peopleModel;
    }

    public void setChe_model(Che_model che_model) {
        this.che_model = che_model;
    }

    public void setChe_list(ArrayList<Che_model> che_list) {
        this.che_list = che_list;
    }

    //返回一级菜单
    public void back1(){
            do{System.out.println("按0返回上一级");
                n=sc.nextInt();
                if(n==0){

                    first_window.first_window();
                }
            }while(!(n ==0));
    }

    //返回二级菜单
    public void back2(){
        do{System.out.println("按0返回上一级");
            n=sc.nextInt();
            if(n==0){

                second_window.second_window();
            }
        }while(!(n ==0));
    }



    //注册
    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------注册界面------------");
        People_model people_model=new People_model();
        System.out.println("请输入用户名");
        people_model.setUsername(sc.next());
        System.out.println("请输入密码");
        people_model.setUserpassword(sc.next());
        people_model.setQuanxian(1);people_model.setMoney(0);//存入一个用户账号,且余额为0
        people_list.add(people_model);
        System.out.println("恭喜你，注册成功 "+people_list.get(people_list.size()-1).getUsername());
back1();
    }

    //登录
    public void login(){

        String username;
        String userpassword;
        System.out.println("------------登录界面------------");
        System.out.println("请输入用户名");
        username=sc.next();
        System.out.println("请输入密码");
        userpassword=sc.next();
        for(i=0;i<people_list.size();i++)
        {
            if(username.equals(people_list.get(i).getUsername())&&userpassword.equals(people_list.get(i).userpassword))
            {
                System.out.println("登录成功");
                second_window.second_window();
                break;
                //进入二级页面
            }
//            else {
//                System.out.println("账户或者密码错误");
//                back1();
            }
        if(i==people_list.size()){
            System.out.println("账户或者密码错误");
                back1();}
        }
        //用户查看所有车辆
    public  void selectcar(){
        System.out.println("------------------车辆信息-------------------");
        System.out.println("车辆编号          车辆类型           是否租借 ");
        for(m=0;m<che_list.size();m++)
        {
            System.out.println(" "+che_list.get(m).getCheid()+"                "+che_list.get(m).getLeixing()+"                 "+che_list.get(m).isHave());
        }
    }
    //用户租借车辆
    public  void zujie(){
        int time;
        System.out.println("是否租借车辆，y为是，其余输入为否");
        if(sc.next().equals("y")){
            System.out.println("请输入租借的车辆的编号");
            String num=sc.next();
            for(m=0;m<che_list.size();m++)
            {
                if(num.equals(che_list.get(m).getCheid())){
                    System.out.println("正在载入租借界面");
                    System.out.println("请问你想租借几个小时(自行车一小时2元，电动车一小时5元)");
                    time=sc.nextInt();
                    if(che_list.get(m).getLeixing()==1)//是自行车
                    {
                        if(people_list.get(i).getMoney()>=2*time)
                        {
                            people_list.get(i).setMoney(people_list.get(i).getMoney()-2*time);
                            che_list.get(m).setUser(i);
                            che_list.get(m).setHave(false);
                            System.out.println("租借成功，扣费"+2*time);
                            back2();
                        }else
                        {
                            System.out.println("余额不足，租借失败");
                            back2();
                        }
                    }
                    if(che_list.get(m).getLeixing()==2)//是电动车
                    {
                        if(people_list.get(i).getMoney()>=5*time)
                        {
                            people_list.get(i).setMoney(people_list.get(i).getMoney()-5*time);
                            che_list.get(m).setUser(i);
                            che_list.get(m).setHave(false);
                            System.out.println("租借成功，扣费"+5*time);
                            back2();
                        }else
                        {
                            System.out.println("余额不足，租借失败");
                            back2();
                        }
                    }
                }
            }
            if(m==che_list.size())
            {
                System.out.println("查无此车");
                back2();
            }
        }back2();
    }
    //查看自己的租车信息
    public void select_myself(){
        for(m=0;m<che_list.size();m++)
        {
            if(che_list.get(m).getUser()==i)
            {
                System.out.println("车辆ID："+che_list.get(m).getCheid());
                System.out.println("以上车辆你未归还");
                back2();
            }
        }
        if(m==che_list.size())
        {
            System.out.println("你未租借任何车辆");
            back2();
        }
    }
    //归还车辆
    public void return_car()
    {
        for(m=0;m<che_list.size();m++)
        {
            if(che_list.get(m).getUser()==i)
            {
                System.out.println("车辆ID："+che_list.get(m).getCheid());
                System.out.println("以上车辆你未归还");
                System.out.println("请输入你归还的车辆编号");
               for(m=0;m<che_list.size();m++)
               {
                   if(che_list.get(m).getCheid().equals(sc.next())&&che_list.get(m).getUser()==i&&che_list.get(m).isHave()==false)
                   {
                       che_list.get(m).setUser(0);che_list.get(m).setHave(true);
                       System.out.println(che_list.get(m).getCheid()+"归还成功");
                       back2();
                   }else
                       {System.out.println("你输入的编号查无此车或者你并未租借此辆");
                        back2();
                       }
               }
            }
        }
        if(m==che_list.size())
        {
            System.out.println("你未租借任何车辆");
            back2();
        }
    }
    //管理员查看所有车辆
    public  void selectcar_admin(){
        System.out.println("-----------------------------车辆信息------------------------------");
        System.out.println("车辆编号          车辆类型           是否租借             租借人编号");
        for(m=0;m<che_list.size();m++)
        {
            System.out.println(" "+che_list.get(m).getCheid()+"                "+che_list.get(m).getLeixing()+"                 "+che_list.get(m).isHave()+"                 "+che_list.get(m).getUser());
        }back2();
    }
    public  void selectcar_admin2(){
        System.out.println("-----------------------------车辆信息------------------------------");
        System.out.println("车辆编号          车辆类型           是否租借             租借人编号");
        for(m=0;m<che_list.size();m++)
        {
            System.out.println(" "+che_list.get(m).getCheid()+"                "+che_list.get(m).getLeixing()+"                 "+che_list.get(m).isHave()+"                 "+che_list.get(m).getUser());
        }
    }
    //管理员查看所有用户
    public void selectuser_admin(){
        System.out.println("-----------------------------用户信息------------------------------");
        System.out.println("  用户名             密码             权限等级               余额");
        for(x=0;x<people_list.size();x++)
        {
            System.out.println(" "+people_list.get(x).getUsername()+"                "+people_list.get(x).getUserpassword()+"                 "+people_list.get(x).getQuanxian()+"                 "+people_list.get(x).getMoney());
        }back2();
    }
    public void selectuser_admin2(){
        System.out.println("-----------------------------用户信息------------------------------");
        System.out.println("  用户名             密码             权限等级               余额");
        for(x=0;x<people_list.size();x++)
        {
            System.out.println(" "+people_list.get(x).getUsername()+"                "+people_list.get(x).getUserpassword()+"                 "+people_list.get(x).getQuanxian()+"                 "+people_list.get(x).getMoney());
        }
    }
    //管理员添加车辆
    public void addcar_admin(){
        Che_model che_model=new Che_model();
        System.out.println("请输入车的编号");
        che_model.setCheid(sc.next());
        System.out.println("请输入车的类型（1为自行车，2为电动车）");
        che_model.setLeixing(sc.nextInt());
        che_model.setHave(true);
        che_model.setUser(0);
        che_list.add(che_model);
        System.out.println("车辆添加完成");
        back2();
    }
    //管理员添加用户
    public void adduser_admin(){
        People_model peopleModel=new People_model();
        System.out.println("请输入账号");
        peopleModel.setUsername(sc.next());
        System.out.println("请输入密码");
        peopleModel.setUserpassword(sc.next());
        peopleModel.setMoney(0);
        peopleModel.setQuanxian(1);
        people_list.add(peopleModel);
        System.out.println("账户添加完成");
        back2();
    }
    //管理员删除车辆
    public void delcar_admin(){
        selectcar_admin2();
        System.out.println("请输入你要删除的车辆编号");
        String name=sc.next();
        for(m=0;m<che_list.size();m++)
        {
            if(name.equals(che_list.get(m).getCheid()))
            {
                che_list.remove(m);
                System.out.println("删除成功");
                back2();
            }
        }if(m==che_list.size()){
            System.out.println("查无此车");
            back2();
        }
    }
    //管理员删除用户
    public  void deluser_admin(){
        selectuser_admin2();
        System.out.println("请输入你要删除人物的用户名");
        String name=sc.next();
        for(x=0;x<people_list.size();x++)
        {
            if(name.equals(people_list.get(x).username))
            {
                people_list.remove(x);
                System.out.println("删除成功");
                back2();
            }
        }if(x==people_list.size()){
            System.out.println("查无此人");
            back2();
        }
    }
    //管理员提升用户权限
    public  void upuser_admin(){
        selectuser_admin2();
        System.out.println("请输入你要提升人物的用户名");
        String name=sc.next();
        for(x=0;x<people_list.size();m++)
        {
            if(name.equals(people_list.get(x).username))
            {
                people_list.get(x).setQuanxian(2);
                System.out.println("已成功提升为管理员权限");
                back2();
            }
        }if(x==people_list.size()){
            System.out.println("查无此人");
            back2();
        }
    }
    }