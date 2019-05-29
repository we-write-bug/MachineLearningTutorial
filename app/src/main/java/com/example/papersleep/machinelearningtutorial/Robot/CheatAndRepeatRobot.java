package com.example.papersleep.machinelearningtutorial.Robot;

public class CheatAndRepeatRobot extends Robot {
    boolean isFirstRound = true;
    int rememberLast;

    public CheatAndRepeatRobot() {
        this.number=1;
        this.name = "CheatAndRepeatRobot";
    }

    //第一轮欺骗，然后复读
    public int calculate(int oppo) {
        int result;
        if (isFirstRound) {
            this.rememberLast = oppo;
            this.isFirstRound = false;
            result = 0;
        } else {
            result = rememberLast;
            this.rememberLast = oppo;
        }
        return result;
    }
}
