package com.example.papersleep.machinelearningtutorial.Robot;


/**
 * 先一直合作 直到被对手欺骗一次后 就一直欺骗
 */
public class TentativeRobot extends Robot {
    boolean whetherBeCheated = false;

    public TentativeRobot() {
        this.number = 8;
        this.name = "TentativeRobot";
    }

    @Override
    public int calculate(int oppoNumber) {
        int result;
        if (whetherBeCheated) {
            result = 0;
        } else {
            result = 1;
        }
        if (oppoNumber == 0) {
            whetherBeCheated = true;
        }    //先让他玩完这次 然后再判断是否被骗

        return result;
    }

}
