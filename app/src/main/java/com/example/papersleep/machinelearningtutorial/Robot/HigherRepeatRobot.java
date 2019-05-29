package com.example.papersleep.machinelearningtutorial.Robot;

/**
 * 一开始跟复读机一样 但被连续欺骗两次后就一直欺骗
 */
public class HigherRepeatRobot extends Robot {
    boolean isFirstRound = true;
    int rememberLast;
    int cheatedTimes;

    public HigherRepeatRobot(){
        this.number=3;
        this.name = "HigherRepeatRobot";
    }

    @Override
    public int calculate(int oppoNumber){
        int result;

        if(cheatedTimes<2){   //没生气之前

            if (isFirstRound){
                this.rememberLast = oppoNumber;  //第一局就跟对手一样
                this.isFirstRound = false;
                result = 1;
            }else{
                result = rememberLast;     //以后跟对手上一局一样

                // 因为没生气之前是与对手上一次相同的 所以在对手第二次欺骗我的那次 我肯定也是欺骗(复读对手第一次欺骗我)

                if(this.rememberLast==0){     //不能用oppoNumber因为是不能看到对手的出牌
                    cheatedTimes+=1;    //无论我出的是什么 对手上次欺骗我 我就记下来
                }else{
                    cheatedTimes=0;     //因为要的是连续被欺骗两次 如果他是0 就重新来过
                }

                this.rememberLast = oppoNumber;
            }

        }else{ result=0; }  //生气了 一直欺骗

        return result;
    }

}
