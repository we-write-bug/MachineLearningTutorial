package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.*;


public class Explanation extends BaseActivity {
    static Class from;
    TextView detail;
    ImageView detailImage;
    Button toFight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explaination);
        detail = findViewById(R.id.detail);
        detailImage = findViewById(R.id.detail_image);
        toFight = findViewById(R.id.back_from_bulb);

        if (from.equals(EnvSetting.class)) {
            detail.setText("比赛环境为八类博弈机器人各8±2只！\n\n在下一页中，你可以任意选择博弈机器人作为进化的陪练。请记住，进化环境与比赛环境约相似，效果可能越佳噢！");
        }else if (from.equals(PracticeActivity.class)){
            detail.setText("比赛环境为八类博弈机器人各8±2只！\n\n在下一页中，你可以任意选择博弈机器人作为进化的陪练。请记住，进化环境与比赛环境约相似，效果可能越佳噢！");
        } else if (from.equals(FuncSetting.class)) { // 设置
            detail.setText("- 轮盘赌选择：模拟自然界的选择，适应度越高越容易被选中。值得一提的是，适应度最高的不一定被选中，适应度最低的也不一定不被选中。\n\n - 精英选择：在轮盘赌选择的基础上，适应度最高的个体一定会被选中。\n\n - 顺序选择：根据适应度的排名，按顺序选择一定数量的个体。\n\n - 倒序选择：根据适应度的倒序排名，选择出一定数量的个体。（退化选择）");
        } else if (from.equals(Evolution.class)) {
            detail.setText(R.string.evo_detail);
        } else if (from.equals(Inquiry.class)) { // 问卷
            detail.setText("我们将根据问卷的结果，预估你的最终得分。\n\n 若觉得有偏差，可在下一页选择“我行我上”，亲自与机器人进行PK。");
        } else if (from.equals(EndingAndSearching.class)) {
            detail.setText(" - 再次进化：重新选择陪练机器人和进化策略，再次进化大白，计算出新得分。\n\n - 重填问卷：重新填写关于性格测试的问卷，重塑你的人格，计算你的新得分。\n\n - 我行我上：亲自上场与八个机器人轮番对战，重新计算得分。 - 下一步：进入下一步。");
        } else if (from.equals(ChromosomeActivity.class)) { // 染色体&适应度
            detail.setText("染色体的构造影响着进化的效率。\n\n注意！适应度最高的个体不一定被选择，适应度最低的个体不一定就会被淘汰！\n\n 所以，为了保证进化效率，有时候需要人为地把最好的个体加进来或是把最差的个体淘汰。");
        }else if (from.equals(CodingActivity.class)) { // 编码
            detail.setText("以每轮博弈进行五局为例，如果0代表对方欺骗，1代表对方合作，2代表未知，我们可以用长度为5的数组表示状态。\n" +
                    "如[2,2,2,2,2]表示第一局；[1,2,2,2,2]表示第二局，且第一局对方选择合作。\n\n" +
                    "这样，我们可以将长度为5的数组看作三进制，转为一个整数对应染色体上的位置。\n\n" +
                    "如22222（三进制）可以转换为242（十进制）。即对应第242号基因。");
        }else if (from.equals(DilemmaActivity.class)) { // 从一个故事说起..
            detail.setText("单次和多次的囚徒困境，结果不会一样。\n\n"+
                    "在重复的囚徒困境中，博弈被反复地进行。因而每个参与者都有机会去“惩罚”另一个参与者前一回合的不合作行为。" +
                    "这时，合作可能会作为平衡的结果出现。" +
                    "欺骗的动机这时可能被惩罚的威胁所克服，从而可能导向一个较好的、合作的结果。\n\n" +
                    "但如果已知是最后一局博弈，囚徒没有必要为维持互信的关系而合作，所以第十局囚徒一定会背叛对方的");
        }else if (from.equals(GeneActivity.class)) { // 另一个故事
            detail.setText("作为上帝，你想进化出最好的个体还是最坏的个体？");
        }else if (from.equals(RuleActivity.class)) { // 游戏规则
            detail.setText("对手作为博弈机器人会分析你之前的行为做出选择。\n\n"+"你需要做的是事情是权衡利弊，并做出你的选择，“合作”或者“欺骗”。\n\n"
            +"请注意，你的选择具有“传染性”，若欺骗成功，你的收益将最大。但对方可能会因为你的欺骗而不再合作！\n"+
            "但如果合作成功，对方可能为了长远利益而与你选择合作。");
        }else if (from.equals(SelectActivity.class)) { // 选择
            detail.setText("轮盘赌选择就是每个个体进入下一代的概率为自身适应度/总适应度。\n\n可以想象，将每个个体放在一个轮盘上，比例大小为自身适应度/总适应度。\n\n当指针在这个转盘上转动，停止下来时指向的个体就是天选之人啦。可以看出，适应性越高的个体被选中的概率就越大。");
            detailImage.setImageResource(R.drawable.example_lunpan);
            detailImage.setVisibility(View.VISIBLE);
        }else if (from.equals(SpecificActivity.class)) { // 遗传算法
            detail.setText("大白与刚刚的博弈机器人原理类似，都可以综合分析前几轮并做出博弈选择。");
            detailImage.setImageResource(R.drawable.example_ga);
            detailImage.setVisibility(View.VISIBLE);
        }else if (from.equals(T_EvolutionActivity.class)) { // 进化
            detail.setText("进化策略、选择策略和突变概率都影响着进化的效率。\n\n" +
                    "此外，进化的代数越多，得到优秀个体的几率就越大。");
        }else if (from.equals(VariationActivity.class)) { // 交叉and变异
            detail.setText("自然界中突变概率约为0.0001。\n\n但为了提高效率，在游戏中你的选择范围为0~0.2。");
        }else if (from.equals(TutorialActivity.class)) { // welcome！
            detail.setText("欢迎来到GeneticGamble。在之后的页面中遇到疑惑，你可以尝试点击小灯泡查看Tips！");
        }
        toFight.setOnClickListener(this);
    }

    public static void startAction(Context context, Class current) {
        from = current;
        Intent intent = new Intent(context, Explanation.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_from_bulb:
                finish();
                break;
        }
    }

}
