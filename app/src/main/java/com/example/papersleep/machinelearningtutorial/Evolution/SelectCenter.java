package com.example.papersleep.machinelearningtutorial.Evolution;

public class SelectCenter {
    public Pop[] eliteSelect(double[] score, Pop[] popList, int newNum) {
        int length = popList.length; //长度

        Pop[] selectedPopList;
        int maxIndex = 0;
        double maxScore = score[0];
        for (int i = 1; i < length; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                maxIndex = i;
            }
        }

        selectedPopList = lunpanSelect(score, popList, newNum);
        selectedPopList[newNum - 1] = popList[maxIndex];
        return selectedPopList;
    }

    public Pop[] lunpanSelect(double[] score, Pop[] popList, int newNum) {
        int length = popList.length; //长度

        Pop[] selectedPopList = new Pop[newNum];

        //计算总分
        double sumScore = 0;
        for (int i = 0; i < length; i++) {
            sumScore += score[i];
        }

        //转换成百分比
        for (int i = 0; i < length; i++) {
            score[i] = score[i] / sumScore;
        }

        //score转成递增百分比,准备轮盘选择
        for (int i = 1; i < length; i++) {
            score[i] = score[i] + score[i - 1];
        }
        score[length - 1] = 1;

        //选择
        for (int i = 0; i < newNum; i++) {
            double p = Math.random();
            for (int j = 0; j < length; j++) {
                if (score[j] > p) {
                    selectedPopList[i] = popList[j];
                    break;
                }
            }
        }

        return selectedPopList;
    }

    public Pop[] rankSelect(double[] score, Pop[] popList, int newNum) {
        Pop[] selectPop = new Pop[newNum];
        for (int i = 0; i < newNum; i++) {
            int index = findMax(score);
            selectPop[i] = (Pop) popList[index].clone();
            score[index] = 0;
        }
        return selectPop;
    }

    public Pop[] daoxuSelect(double[] score, Pop[] popList, int newNum){
        Pop[] selectPop = new Pop[newNum];
        for (int i = 0; i < newNum; i++) {
            int index = findMin(score);
            selectPop[i] = (Pop) popList[index].clone();
            score[index] = 0;
        }
        return selectPop;
    }

    public int findMin(double[] score) {
        int minIndex = 0;
        double minValue = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] < minValue) {
                minIndex = i;
                minValue = score[i];
            }
        }
        return minIndex;
    }

    public int findMax(double[] score) {
        int maxIndex = 0;
        double maxValue = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] > maxValue) {
                maxIndex = i;
                maxValue = score[i];
            }
        }
        return maxIndex;
    }
}
