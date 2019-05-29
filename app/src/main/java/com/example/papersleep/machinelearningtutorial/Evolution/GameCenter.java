package com.example.papersleep.machinelearningtutorial.Evolution;


import android.os.Build;
import android.support.annotation.RequiresApi;
import com.example.papersleep.machinelearningtutorial.Robot.*;

import java.util.*;

public class GameCenter {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        GameCenter gameCenter = new GameCenter();
//        gameCenter.printPreInfo();
//        test();
        Map map = new HashMap();
        Map setting = getSetting();
        for (int i = 1; i <= 8; i++) {
            map.put(i, 8);
        }
        map.put("Iteration", 999);
        map.put("Option", 1); //
        map.put("Cross", 0);
        map.put("Mutation", 0.1);
        map.put("test", true);
        ArrayList res = GameCenter.betterCultivate(map);
        ArrayList<Integer> score = (ArrayList<Integer>) res.get(0);
        System.out.println(score.stream().max(Comparator.comparing(integer -> integer)).get());
        Pop best = (Pop) res.get(1);
        System.out.println("检查一下" + best.getScore());
//        Pop bestPop = (Pop) res.get(1);
//        System.out.println(GameCenter.battle(bestPop, map));
//        Integer[] test = new Integer[]{1, 1, 0, 0, 0};
//        UserPop user = new UserPop(test);
//        System.out.println(GameCenter.battle(user,map));
    }

    public static Map getSetting() {
        Map setting = new HashMap();
        for (int i = 1; i <= 8; i++) {
            setting.put(i, 6 + (int) (Math.random() * 5));
        }
        return setting;
    }

    public void printPreInfo() {
        /**
         * 打印准备信息
         */
        System.out.println("*********************Game:囚徒困境**********************");
        System.out.println("-------------------------------------------------------");
        System.out.println("|  游戏规则:       合作     欺骗                        |");
        System.out.println("|             合作 +2\\+2   +0\\+3                       |");
        System.out.println("|             欺骗 +3\\+0   +1\\+1                       |");
        System.out.println("-------------------------------------------------------");
        System.out.println("|  请选择机器人:                                        |");
        System.out.println("|  [1]CheatAndRepeatRobot                              |");
        System.out.println("|  [2]CraftyRobot                                      |");
        System.out.println("|  [3]HigherRepeatRobot                                |");
        System.out.println("|  [4]KingRobot                                        |");
        System.out.println("|  [5]RegularFirstRobot                                |");
        System.out.println("|  [6]RepeatRobot                                      |");
        System.out.println("|  [7]StubbornRobot                                    |");
        System.out.println("|  [8]TentativeRobot                                   |");
        System.out.println("|  [0]结束选择                                          |");
        System.out.println("--------------------------------------------------------");
    }

    public ArrayList<Integer> dealPre() {
        /**
         * 处理准备信息，以Arraylist形式返回
         * Arraylist中，奇数位为机器人编号，偶数位为机器人个数
         */
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            System.out.print(" 您选择的选择机器人编号：");
            int num = in.nextInt();
            if (num == 0) {
                System.out.print(" 您是否要结束选择？[Y]确认结束 [N]取消:");
                if ("Y".equals(in.next())) {
                    System.out.println(" 结束选择");
                    System.out.println("--------------------------------------------------------");
                    break;
                }
            } else {
                result.add(num);
                System.out.print(" 您选择[" + num + "]号机器人的个数为：");
                result.add(in.nextInt());
            }
        }
        return result;
    }

    public static Robot[] getRobot(ArrayList<Integer> data) {
        int allsize = 0;
        for (int i = 1; i < data.size(); i += 2) {
            allsize += data.get(i);
        }
        Robot[] robots = new Robot[allsize];
        int count = 0;
        for (int i = 0; i < data.size(); i += 2) {
            switch (data.get(i)) {
                case 1:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new CheatAndRepeatRobot();
                        count++;
                    }
                    break;
                case 2:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new CraftyRobot();
                        count++;
                    }
                    break;
                case 3:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new HigherRepeatRobot();
                        count++;
                    }
                    break;
                case 4:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new KindRobot();
                        count++;
                    }
                    break;
                case 5:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new RegularFirstRobot();
                        count++;
                    }
                    break;
                case 6:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new RepeatRobot();
                        count++;
                    }
                    break;
                case 7:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new StubbornRobot();
                        count++;
                    }
                    break;
                case 8:
                    for (int j = 0; j < data.get(i + 1); j++) {
                        robots[count] = new TentativeRobot();
                        count++;
                    }
                    break;
            }
        }
        return robots;
    }

    public static int battle(UserPop user, Map setting) {
        return user.battleWithRobot(setting);
    }

    public static int battle(Pop pop, Map setting) {
        //
        //传入一个pop和data
        //data包含了指定的环境数据，让pop在这个环境中play
        //返回最后的分数
        //
        pop.setScore(0);
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            if (setting.containsKey(i)) {
                data.add(i);
                data.add((int) setting.get(i));
            }
        }
        PlayCentre playCentre = new PlayCentre();
        Robot[] robots = getRobot(data);
        for (Robot temp : robots) {
            playCentre.playTest(pop, temp);
        }
        return pop.getScore();
    }

    public static ArrayList cultivatePlay(Map in) {
        /**
         * 返回的arraylist第0位是分数的arraylist
         * 第1位是一个Pop
         * 第2位是finalScore
         */
        ArrayList<Integer> data = new ArrayList<>();
        //一代的数量
        int numGeneration = 50;
        double mutationP = (double) in.get("Mutation");
        int iteration = (int) in.get("Iteration");
        int crossStrategy = (int) in.get("Cross"); // 交叉策略
        //让用户选择进化策略
        int selectStrategy = (int) in.get("Option"); // 选择策略
//        System.out.println("--------------------选择策略----------------------");
//        System.out.println("| [1]精英选择                                     |");
//        System.out.println("| [2]轮盘赌选择                                   |");
//        System.out.println("| [3]顺序选择                                     |");
//        System.out.println("| [4]我不懂，随便吧                               |");
//        System.out.println("--------------------------------------------------");
//        System.out.print("你的选择是：");
//        selectStrategy = in.nextInt();
//        in.close();
//
//        // 这个是选择概率，等等记得改掉
        double selectedP = 0.4;
//        // 同上同上同上注意

        for (int i = 1; i <= 8; i++) {
            if (in.containsKey(i)) {
                data.add(i);
                data.add((int) in.get(i));
            }
        }

        Robot[] robots;
        Pop[] popList = new Pop[numGeneration];
        Pop[] selectedPop;
        Pop[] crossPop;
        ArrayList result = new ArrayList<>();
        ArrayList<Integer> finalScore = new ArrayList<>();

        PlayCentre playCentre = new PlayCentre();
        EvolutionCentre evolutionCentre = new EvolutionCentre();

        Pop best = new Pop(243); //记录最好的Pop

        for (int i = 0; i < numGeneration; i++) {
            popList[i] = new Pop(243);
        }

        ArrayList<Integer> scoreLi = new ArrayList<>();
        for (int i = 0; i < iteration; i++) {
            for (Pop temp : popList) {
                robots = getRobot(data);
                temp.setScore(0);
                for (Robot robot : robots) {
                    playCentre.playTest(temp, robot);
                }
                scoreLi.add(temp.getScore()); //scoreLi是每一代的得分列表
            }

            int tempScore = scoreLi.get(0);
            for (Integer integer : scoreLi) {
                if (integer > tempScore)
                    tempScore = integer;
            }
            finalScore.add(tempScore);
            // 把每轮最高分加到finalScore里面

            System.out.println("第" + i + "轮最高分为" + tempScore);

            if (selectStrategy == 4) {
                if (i == 0)
                    best = popList[0];
                System.out.println(tempScore + "  " + best.getScore());
                for (int j = 0; j < numGeneration; j++) {
                    if (scoreLi.get(j) == tempScore && tempScore <= best.getScore()) {
                        best = popList[j];
                        break;
                    }
                }
            } else {
                for (int j = 0; j < numGeneration; j++) {
                    if (scoreLi.get(j) == tempScore && tempScore >= best.getScore()) {
                        best = popList[j];
                        break;
                    }
                }
            }

            scoreLi.clear();

            selectedPop = evolutionCentre.select(popList, (int) (selectedP * numGeneration), selectStrategy);
            crossPop = evolutionCentre.crossover(popList, numGeneration - (int) (selectedP * numGeneration), crossStrategy);
            if ((int) (selectedP * numGeneration) >= 0)
                System.arraycopy(selectedPop, 0, popList, 0, (int) (selectedP * numGeneration));
            if (numGeneration - (int) (selectedP * numGeneration) >= 0)
                System.arraycopy(crossPop, 0, popList, (int) (selectedP * numGeneration) + 0, numGeneration - (int) (selectedP * numGeneration));
            evolutionCentre.mutation(popList, mutationP);
        }

        result.add(finalScore);
        //  把最好的个体给选出来放到返回里面
        result.add(best);

        return result;
    }

    public static int userPlay(Integer[] wenQuan, Map setting) {
        UserPop userPop = new UserPop(wenQuan);
        return userPop.battleWithRobot(setting);
    }

    public static ArrayList betterCultivate(Map in) {
        //
        //返回的arraylist第0位是分数的arraylist
        //第1位是一个Pop
        //第2位是finalScore
        //
        ArrayList result = new ArrayList();
        ArrayList<Integer> data = new ArrayList<>();
        //一代的数量
        int numGeneration = 50;
        double mutationP = (double) in.get("Mutation");
        int iteration = (int) in.get("Iteration");
        int crossStrategy = (int) in.get("Cross"); // 交叉策略
        //让用户选择进化策略
        int selectStrategy = (int) in.get("Option"); // 选择策略
//        // 这个是选择概率，等等记得改掉
        double selectedP = 0.4;
//        // 同上同上同上注意

        for (int i = 1; i <= 8; i++) {
            if (in.containsKey(i)) {
                data.add(i);
                data.add((int) in.get(i));
            }
        }

        Robot[] robots;
        Pop[] popList = new Pop[numGeneration];
        Pop[] selectedPop;
        Pop[] crossPop;
        ArrayList<Integer> finalScore = new ArrayList<>();

        PlayCentre playCentre = new PlayCentre();
        EvolutionCentre evolutionCentre = new EvolutionCentre();

        Pop best = new Pop(243 * 8); //记录最好的Pop

        for (int i = 0; i < numGeneration; i++) {
            popList[i] = new Pop(243 * 8);
        }

        ArrayList<Integer> scoreLi = new ArrayList<>();
        for (int i = 0; i < iteration; i++) {
            for (Pop temp : popList) {
                robots = getRobot(data);
                temp.setScore(0);
                for (Robot robot : robots) {
                    playCentre.playTest(temp, robot);
                }
                scoreLi.add(temp.getScore()); //scoreLi是每一代的得分列表
            }

            int tempScore = scoreLi.get(0);
            for (Integer integer : scoreLi) {
                if (integer > tempScore)
                    tempScore = integer;
            }
            finalScore.add(tempScore);
            // 把每轮最高分加到finalScore里面

            System.out.println("第" + i + "轮最高分为" + tempScore);
            for (int j = 0; j < numGeneration; j++) {
                if (scoreLi.get(j) == tempScore && tempScore >= best.getScore()) {
                    best = popList[j];
                    break;
                }
            }

            scoreLi.clear();

            selectedPop = evolutionCentre.select(popList, (int) (selectedP * numGeneration), selectStrategy);
            crossPop = evolutionCentre.crossover(popList, numGeneration - (int) (selectedP * numGeneration), crossStrategy);
            if ((int) (selectedP * numGeneration) >= 0)
                System.arraycopy(selectedPop, 0, popList, 0, (int) (selectedP * numGeneration));
            if (numGeneration - (int) (selectedP * numGeneration) >= 0)
                System.arraycopy(crossPop, 0, popList, (int) (selectedP * numGeneration), numGeneration - (int) (selectedP * numGeneration));
            evolutionCentre.mutation(popList, mutationP);
        }
        result.add(finalScore);
        //  把最好的个体给选出来放到返回里面
        result.add(best);

        return result;
    }
}
