package com.example.papersleep.machinelearningtutorial.not_activity;

import java.io.*;
import java.net.Socket;

public class MyClients {
    Socket client;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));//example


    public void connect() {
        try {
            this.client = new Socket("172.27.140.120", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String msg) {
        try {
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        try {
            dis = new DataInputStream(client.getInputStream());
            return dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean login(String uName, String hName, MyClients x) throws IOException {
        x.send(uName);
        x.send(hName);

        do {
            String temp = x.receive();
            if (temp != null) {
                switch (temp) {
                    case "此房间未被创建过！创建房间成功！":
                    case "此房间有一人正在等待！":
                        return true;
                    case "此房间已经有人创建且人数已满！请换一个房间号！":
                        return false;
                }
            }
        } while (true);

    }

    public static int submit(int choice, MyClients x) {
        int res;
        x.send(String.valueOf(choice));

        while (true) {
            String temp = x.receive();
            if (temp != null) {
                res = Integer.valueOf(temp);
                break;
            }
        }
        return res;
    }

    public Socket getClient() {
        return client;
    }
}