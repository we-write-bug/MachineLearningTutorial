package com.example.papersleep.machinelearningtutorial.not_activity;

import com.example.papersleep.machinelearningtutorial.Evolution.Pop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.PooledConnection;

public class DataCollector {
    public static Integer scoreFinal = 0;
    public static Integer choose = 1;
    public static Integer cross = 1;
    public static Integer iteration = 50;
    public static Integer forTest;
    public static Integer ID = 0;
    public static Integer in = 0;
    public static String uName = "";
    public static String hName = "";
    public static Boolean inquiryOut = false;
    public static Double mutate = 0.01;
    public static Integer[] inquiry = new Integer[5];
    public static Integer[] nums = new Integer[8];
    public static ArrayList<Integer> scores;
    public static Pop bestOne;
    public static Integer total;
    public static Map workenvir;
    public static Integer new_end_yours;
    public static Integer new_end_yourms;
    public static Integer new_end_yournms;
    public static ArrayList<Integer> new_score_list;
    public static Pop new_bestOne;

    static {
        for (int i = 0; i < 8; i++) nums[i] = 0;
        for (int i = 0; i < 5; i++) inquiry[i] = 1;
    }

    public static Map toMap() {
        Map map = new HashMap();
        for (int i = 0; i < 8; i++)
            map.put(i + 1, nums[i]);

        map.put("Inquiry", inquiry);
        map.put("Option", choose);
        map.put("Cross", cross);
        map.put("Iteration", iteration);
        map.put("Mutation", mutate);
        return map;
    }

}
