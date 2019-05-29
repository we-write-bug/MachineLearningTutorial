package com.example.papersleep.machinelearningtutorial.Robot;

public class RegularFirstRobot extends Robot {
    int round = 0;

    public RegularFirstRobot() {
        this.number = 5;
        this.name = "RegularFirstRobot";
    }

    @Override
    public int calculate(int oppoNumber) {
//        第1，2，5，6，轮欺骗，其他合作
        int result = 0;
        if (round == 0 || round == 1 || round == 4 || round == 5) {
            result = 0;
        } else {
            result = 1;
        }
        round++;
        return result;
    }
}
