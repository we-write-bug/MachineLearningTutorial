package com.example.papersleep.machinelearningtutorial.not_activity;

import java.sql.SQLOutput;

public class NetworkCollector {
    public static MyClients x;
    static {
        System.out.println("&&&&&&&&&&&&&");

        x = new MyClients();

        System.out.println("------------");

        x.connect();

        System.out.println("00000000000000");

        while (!x.receive().equals("你已成功连接服务器！")) ;

    }
}
