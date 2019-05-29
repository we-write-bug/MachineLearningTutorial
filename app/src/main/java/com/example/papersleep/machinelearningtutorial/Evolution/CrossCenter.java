package com.example.papersleep.machinelearningtutorial.Evolution;

public class CrossCenter {
    public static Pop[] doubleCross(Pop[] popList, int newNum){
        Pop[] crossPop = new Pop[newNum];
        int length = popList.length;
        int chromLength = popList[0].chrom.length;
        for (int i = 0; i < newNum; i++) {

            //随机生成两个整数，代表要交叉的个体
            int point1 = (int) Math.floor(Math.random() * length);
            int point2 = (int) Math.floor(Math.random() * length);
            while (point1 == point2)
                point2 = (int) Math.floor(Math.random() * length);

            //交叉位点，且保证crosspoint1<=crosspoint2
            int crossPoint1 = (int) Math.floor(Math.random() * chromLength);
            int crossPoint2 = (int) Math.floor(Math.random() * chromLength);
            if (crossPoint1 > crossPoint2) {
                int temp = crossPoint1;
                crossPoint1 = crossPoint2;
                crossPoint2 = temp;
            }

            //开始交叉辣
            int[] chrom1 = new int[chromLength];
            int[] chrom2 = new int[chromLength];
            Pop copyOne = (Pop) popList[point1].clone();
            Pop copyTwo = (Pop) popList[point2].clone();
            for (int j = crossPoint1; j < crossPoint2; j++) {
                copyOne.chrom[j] = copyTwo.chrom[j];
            }
            crossPop[i] = copyOne;

        }
        return crossPop;
    }

    public static Pop[] oneCross(Pop[] popList,int newNum){
        Pop[] crossPop = new Pop[newNum];
        int length = popList.length;
        int chromLength = popList[0].chrom.length;
        for (int i = 0; i < newNum; i++) {

            //随机生成两个整数，代表要交叉的个体
            int point1 = (int) Math.floor(Math.random() * length);
            int point2 = (int) Math.floor(Math.random() * length);
            while (point1 == point2)
                point2 = (int) Math.floor(Math.random() * length);

            //生成一个交叉位点
            int crossPoint = (int) Math.floor(Math.random() * chromLength);
            while (crossPoint == 0)
                crossPoint = (int) Math.floor(Math.random() * chromLength);

            //开始交叉辣
            Pop copyOne = (Pop) popList[point1].clone();
            Pop copyTwo = (Pop) popList[point2].clone();
            for (int j = 0; j < crossPoint; j++) {
                copyOne.chrom[j] = copyTwo.chrom[j];
            }
            crossPop[i] = copyOne;

        }
        return crossPop;
    }
}
