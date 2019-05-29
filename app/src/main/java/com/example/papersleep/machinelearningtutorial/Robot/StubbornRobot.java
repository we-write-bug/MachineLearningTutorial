package com.example.papersleep.machinelearningtutorial.Robot;


/**
 *先合作
 * 如果对手选择合作，跟上一轮一样，即使上一轮犯错了也一样。
 * 如果对手选择欺骗，我会做出跟上一轮相反的选择，犯错了也一样。
 */
public class StubbornRobot extends Robot {
    boolean isFirstRound = true;
    int myLastChoice;
    int oppoLastChoice;

    public StubbornRobot(){
        this.number = 7;
        this.name="StubbornRobot";
    }

    @Override
    public int calculate(int oppoNumber) {
        int result;
        if(isFirstRound){
            result = 1;
            this.isFirstRound = false;
        }else{
            if(oppoLastChoice==1){   //上一局对手选的是合作 我不变
                result=myLastChoice;
            }else{  //对手上一局选的欺骗  我变
                if(myLastChoice==1){ result=0; }
                else{ result=1; }
            }
        }
        this.oppoLastChoice=oppoNumber;
        this.myLastChoice=result;

        return result;
    }

}
