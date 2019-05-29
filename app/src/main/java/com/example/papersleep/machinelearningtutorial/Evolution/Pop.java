package com.example.papersleep.machinelearningtutorial.Evolution;


import com.example.papersleep.machinelearningtutorial.Robot.Robot;

public class Pop {
    int[] chrom;
    private double percent = 0;
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
    public void addScore(int score){
        this.score += score;
    }

    public Pop(int chromLength) {
        chrom = new int[chromLength];
        for (int i = 0; i < chromLength; i++) {
            chrom[i] = (int) Math.round(Math.random());
        }
    }

    @Override
    public Object clone() {
        Pop pop = new Pop(243);
        pop.chrom = chrom.clone();
        pop.setScore(score);
        return pop;
    }

    public int getStrategy(int[] status, Robot oppo) {
        int index = 0;
        for (int i = 0; i < status.length; i++) {
            index += status[i] * (Math.pow(3, i));
        }
        if (chrom.length==243){
            return chrom[index];
        }else {
            return chrom[index + 243 * (oppo.number - 1)];
        }
    }
}
