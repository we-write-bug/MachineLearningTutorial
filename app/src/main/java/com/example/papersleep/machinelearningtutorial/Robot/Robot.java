package com.example.papersleep.machinelearningtutorial.Robot;

import java.util.Scanner;

public abstract class Robot {
    /*
     * 游戏规则：
     *
     * 1均代表合作，0均代表欺骗
     *
     *            合作      欺骗
     *    合作   +2\+2      +3/+0
     *    欺骗   +0\+3      +1/+1
     * 若都合作，执行cooperate方法，分数+3分
     * 若被欺骗，执行beCheated方法，分数+1分
     * 若欺骗成功，执行cheat方法，分数++4分
     * 若都欺骗·，执行notCooperate方法，分数+2分*/
    public int score = 0;
    public String name = "Robot";
    public int number;

    /**
     * 继承出来的子类写一个构造函数，把name改掉
     */
    public void cooperate() {
        score += 2;
    }

    public void cheat() {
        score += 3;
    }

    public void beCheated() {
        score += 0;
    }

    public void notCooperate() {
        score += 1;
    }

    public void calculateScore(int myChoose, int oppoChoose) {
        /**
         * 该方法用于计算成绩，传入第一个参数为本人该轮选择，第二个参数为对手选择
         * 1均代表合作，0均代表欺骗
         */
        if (myChoose == 1 && oppoChoose == 1) {
            this.cooperate();
        } else if (myChoose == 1 && oppoChoose == 0) {
            this.beCheated();
        } else if (myChoose == 0 && oppoChoose == 1) {
            this.cheat();
        } else if (myChoose == 0 && oppoChoose == 0) {
            this.notCooperate();
        }
    }

    public void printScore() {
        /**
         * 打印成绩方法
         */
        System.out.println("My name is " + name + ".");
        System.out.println("My score is " + score + ".");
    }

    public int calculate(int oppoNumber) {
        return 0;
    }

    public void play(int num) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            System.out.println("*****第" + (i + 1) + "轮******");
            System.out.print("请输入你的选择，1代表合作，0代表欺骗:");
            int oppo = in.nextInt();
            int result = calculate(oppo);
            System.out.println("机器人的选择是" + result);
            calculateScore(result, oppo);
        }
    }
}
