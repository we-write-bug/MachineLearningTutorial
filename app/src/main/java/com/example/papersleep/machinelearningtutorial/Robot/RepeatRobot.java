package com.example.papersleep.machinelearningtutorial.Robot;


public class RepeatRobot extends Robot {
    boolean isFirstRound = true;
    int rememberLast;

    public RepeatRobot(){
        this.name = "RepeatedRobot";
        this.number = 6 ;
    }
    public int calculate(int oppo){
        int result;
        if (isFirstRound){
            this.rememberLast = oppo;
            this.isFirstRound = false;
            result = 1;
        }else{
            result = rememberLast;
            this.rememberLast = oppo;
        }
        return result;
    }

}
