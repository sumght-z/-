package com.stx.Project_1;

import java.util.*;

public class Test_main {
        public static void main(String[] args) {
        People_model peopleModel=new People_model();
        Dao dao=new Dao();
        dao.setPeopleModel(peopleModel);
        ArrayList<People_model> people_list = new ArrayList<People_model>();//实例化一个人的arraylist
        dao.setPeople_list(people_list);

        peopleModel.setUsername("admin");peopleModel.setUserpassword("admin");peopleModel.setQuanxian(2);peopleModel.setMoney(0);//存入一个管理员账号
        people_list.add(peopleModel);peopleModel=new People_model();

        //System.out.println(people_list.get(0).getUsername());

        Che_model cheModel=new Che_model();
        ArrayList<Che_model> che_list = new ArrayList<Che_model>();//实例化一个车的arraylist
        dao.setChe_list(che_list);
        cheModel.setCheid("D1");cheModel.setHave(true);cheModel.setLeixing(1);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个电动车
        cheModel.setCheid("D2");cheModel.setHave(true);cheModel.setLeixing(1);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个电动车
        cheModel.setCheid("D3");cheModel.setHave(true);cheModel.setLeixing(1);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个电动车
        cheModel.setCheid("D4");cheModel.setHave(true);cheModel.setLeixing(1);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个电动车
        cheModel.setCheid("D5");cheModel.setHave(true);cheModel.setLeixing(1);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个电动车
        cheModel.setCheid("Z6");cheModel.setHave(true);cheModel.setLeixing(2);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个自行车
        cheModel.setCheid("Z7");cheModel.setHave(true);cheModel.setLeixing(2);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个自行车
        cheModel.setCheid("Z8");cheModel.setHave(true);cheModel.setLeixing(2);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个自行车
        cheModel.setCheid("Z9");cheModel.setHave(true);cheModel.setLeixing(2);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个自行车
        cheModel.setCheid("Z10");cheModel.setHave(true);cheModel.setLeixing(2);cheModel.setUser(0);che_list.add(cheModel);cheModel=new Che_model();//存入一个自行车
//        for(int i=0;i<10;i++)
//        {System.out.println(che_list.get(i).getCheid());}
        First_window first_window=new First_window();
        first_window.setDao(dao);
        Second_window second_window=new Second_window();//
        second_window.setDao(dao);//
        dao.setFirst_window(first_window);
        dao.setSecond_window(second_window);
        first_window.first_window();

    }
}
