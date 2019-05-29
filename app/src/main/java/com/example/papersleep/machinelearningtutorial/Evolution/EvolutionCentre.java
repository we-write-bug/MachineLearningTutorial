package com.example.papersleep.machinelearningtutorial.Evolution;

public class EvolutionCentre {
    public Pop[] select(Pop[] popList, int newNumber, int stategy) {
        int length = popList.length;
        double[] score = new double[length];

        //把每个待进化机器人的得分存到一个score数组里
        for (int i = 0; i < length; i++) {
            score[i] = (double) popList[i].getScore();
        }

        SelectCenter selectCenter = new SelectCenter();
        switch (stategy) { // 1 精英选择 2 轮盘选择 3 顺序选择 4 退化选择
            case 2:
                return selectCenter.lunpanSelect(score, popList, newNumber);
            case 3:
                return selectCenter.rankSelect(score, popList, newNumber);
            case 4:
                return selectCenter.daoxuSelect(score,popList,newNumber);
            case 1:
                return selectCenter.eliteSelect(score, popList, newNumber);
        }

        return selectCenter.eliteSelect(score, popList, newNumber);
    }

    public Pop[] crossover(Pop[] popList, int newNum, int stategy) {
        // stategy 1代表双点交叉，2代表单点交叉
        switch (stategy) {
            case 1:
                return CrossCenter.doubleCross(popList, newNum);
            case 2:
                return CrossCenter.oneCross(popList, newNum);
            default:
                return CrossCenter.doubleCross(popList, newNum);
        }
    }

    public void mutation(Pop[] popList, double p) {
        int chromLength = popList[0].chrom.length;

        //遍历所有Pop，按突变概率来突变
        for (Pop temp : popList) {
            if (Math.random() < p) {
                int mPoint = (int) Math.floor(Math.random() * chromLength);
                if (temp.chrom[mPoint] == 0)
                    temp.chrom[mPoint] = 1;
                else
                    temp.chrom[mPoint] = 0;
            }
        }
    }
}
