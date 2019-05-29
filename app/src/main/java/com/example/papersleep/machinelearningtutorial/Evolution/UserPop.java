package com.example.papersleep.machinelearningtutorial.Evolution;


import com.example.papersleep.machinelearningtutorial.Robot.*;

import java.util.Map;

public class UserPop {
    Integer[] chorm;
    int score;
    int index;

    // 五个基因,第一个是第一轮博弈选择0，第二个是合作选择1，第三个是欺骗选择2，第四个是被骗选择3，第五个是骗了别人的选择4
    // 合作是1，欺骗是0
    public UserPop(Integer[] chorm) {
        this.chorm = chorm;
    }

    /**
     * 传一个robot进来，根据user问卷调查得到的人格进行五局游戏
     * 返回最终得分
     *
     * @param setting
     * @return
     */
    public int battleWithRobot(Map setting) {
        int memory = 0;
        Robot robot;
        for (int index = 1 ; index <=8 ; index++){ // 遍历每个键
            if (setting.containsKey(index))
                for (int j = 0 ; j < (int)setting.get(index);j++){ // 每个机器人play几次
                robot = getRobot(index); // 得到新的机器人
                memory = 0; // 初始化memory
                for (int i = 0; i < 5; i++) { // 和机器人进行五局游戏
                    int my = chorm[memory]; // my策略
                    int oppo = robot.calculate(my); //机器人策略
                    calScore(my, oppo); //加分
                    memory = modeMemory(my, oppo); // 调整memory
                }
            }
        }

        return score;
    }

    public void calScore(int my, int oppo) {
        int result = 0;
        if (my == 1 && oppo == 1) {
            result = 2;
        } else if (my == 1 && oppo == 0) {
            result = 0;
        } else if (my == 0 && oppo == 1) {
            result = 3;
        } else if (my == 0 && oppo == 0) {
            result = 1;
        }
        score += result;
    }

    public int modeMemory(int my, int oppo) {
        int result = 0;
        if (my == 1 && oppo == 1) {
            result = 1;
        } else if (my == 1 && oppo == 0) {
            result = 3;
        } else if (my == 0 && oppo == 1) {
            result = 4;
        } else if (my == 0 && oppo == 0) {
            result = 2;
        }
        return result;
    }

    public Robot getRobot(int indexOfRobot) {
        switch (indexOfRobot) {
            case 1:
                return new CheatAndRepeatRobot();
            case 2:
                return new CraftyRobot();
            case 3:
                return new HigherRepeatRobot();
            case 4:
                return new KindRobot();
            case 5:
                return new RegularFirstRobot();
            case 6:
                return new RepeatRobot();
            case 7:
                return new StubbornRobot();
            case 8:
                return new TentativeRobot();
            default:
                return new RepeatRobot();
        }
    }
}
