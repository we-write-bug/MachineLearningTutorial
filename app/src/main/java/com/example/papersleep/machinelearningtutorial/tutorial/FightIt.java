package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.Robot.CheatAndRepeatRobot;
import com.example.papersleep.machinelearningtutorial.Robot.CraftyRobot;
import com.example.papersleep.machinelearningtutorial.Robot.HigherRepeatRobot;
import com.example.papersleep.machinelearningtutorial.Robot.KindRobot;
import com.example.papersleep.machinelearningtutorial.Robot.RegularFirstRobot;
import com.example.papersleep.machinelearningtutorial.Robot.RepeatRobot;
import com.example.papersleep.machinelearningtutorial.Robot.Robot;
import com.example.papersleep.machinelearningtutorial.Robot.StubbornRobot;
import com.example.papersleep.machinelearningtutorial.Robot.TentativeRobot;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

import java.util.ArrayList;
import java.util.Random;

public class FightIt extends BaseActivity {
    Button ally;
    Button betray;
    Button toGene;
    Button nextOne;
    TextView title;
    TextView yourS;
    TextView itsS;
    TextView finalRes;
    ImageView you;
    ImageView it;
    ImageView yourC;
    ImageView itsC;
    ImageView comRes;
    Integer times = 0;
    Integer yourScore = 0;
    Integer totalScore = 0;
    Integer itsScore = 0;
    Robot[] robotSet = new Robot[8];
    ArrayList robot = new ArrayList();
    Robot currentR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_it);
        robotSet[0] = new CheatAndRepeatRobot();
        robotSet[1] = new CraftyRobot();
        robotSet[2] = new HigherRepeatRobot();
        robotSet[3] = new KindRobot();
        robotSet[4] = new RegularFirstRobot();
        robotSet[5] = new RepeatRobot();
        robotSet[6] = new StubbornRobot();
        robotSet[7] = new TentativeRobot();

        ally = findViewById(R.id.ally);
        betray = findViewById(R.id.betray);
        toGene = findViewById(R.id.to_gene);
        nextOne = findViewById(R.id.next_one);
        title = findViewById(R.id.title);
        yourC = findViewById(R.id.your_c);
        itsC = findViewById(R.id.its_c);
        you = findViewById(R.id.you);
        it = findViewById(R.id.it);
        yourS = findViewById(R.id.your_s);
        itsS = findViewById(R.id.its_s);
        comRes = findViewById(R.id.com_res);
        finalRes = findViewById(R.id.final_res);

        title.setText(R.string.fight_title);
        yourS.setText(String.format("Your score:\n%d", yourScore));
        itsS.setText(String.format("Its score:\n%d", itsScore));
        ally.setOnClickListener(this);
        betray.setOnClickListener(this);
        toGene.setOnClickListener(this);
        nextOne.setOnClickListener(this);
        comRes.setImageResource(R.drawable.xx);
        startNext();
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, FightIt.class);
        context.startActivity(intent);
    }

    public void startNext() {
        int id = new Random().nextInt(8);
        while (robot.contains(id))
            id = new Random().nextInt(8);
        robot.add(id);
        currentR = robotSet[id];
        it.setImageResource(id == 0 ? R.drawable.ca :
                id == 1 ? R.drawable.im :
                        id == 2 ? R.drawable.fury :
                                id == 3 ? R.drawable.hulk :
                                        id == 4 ? R.drawable.thor :
                                                id == 5 ? R.drawable.groot :
                                                        id == 6 ? R.drawable.spider :
                                                                R.drawable.panther);
        yourScore = 0;
        itsScore = 0;
        nextOne.setVisibility(View.GONE);
        ally.setVisibility(View.VISIBLE);
        betray.setVisibility(View.VISIBLE);
        yourS.setText(String.format("Your score:\n%d", yourScore));
        itsS.setText(String.format("Its score:\n%d", itsScore));
        Toast.makeText(this, "新对⼿出现", Toast.LENGTH_SHORT).show();

    }

    public void endThis() {
        totalScore += yourScore;
        findViewById(R.id.ally).setVisibility(View.GONE);
        findViewById(R.id.betray).setVisibility(View.GONE);
        nextOne.setVisibility(View.VISIBLE);
    }

    public void battleTest(Robot r, int choose) {
        int temp = r.calculate(choose);
        yourC.setImageResource(choose == 0 ? R.drawable.test2 : R.drawable.test2);
        itsC.setImageResource(temp == 0 ? R.drawable.test2 : R.drawable.test2);
        comRes.setImageResource
                (choose == 0 && temp == 0 ? R.drawable.bb :
                        choose == 0 && temp == 1 ? R.drawable.ba :
                                choose == 1 && temp == 0 ? R.drawable.ab :
                                        R.drawable.aa);
        yourScore +=
                (choose == 0 && temp == 0 ? 1 :
                        choose == 0 && temp == 1 ? 3 :
                                choose == 1 && temp == 0 ? 0 : 2);
        itsScore +=
                (choose == 0 && temp == 0 ? 1 :
                        choose == 0 && temp == 1 ? 0 :
                                choose == 1 && temp == 0 ? 3 : 2);

        yourS.setText(String.format("Your score:\n%d", yourScore));
        itsS.setText(String.format("Its score:\n%d", itsScore));

        times++;
        if (times % 5 == 0) endThis();
        if (times == 15) {
            nextOne.setVisibility(View.GONE);
            comRes.setVisibility(View.GONE);
            itsC.setVisibility(View.GONE);
            yourC.setVisibility(View.GONE);
            finalRes.setVisibility(View.VISIBLE);
            finalRes.setText(String.format("你的总分为 %d", totalScore));
            toGene.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ally:
                battleTest(currentR, 1);
                break;
            case R.id.betray:
                battleTest(currentR, 0);
                break;
            case R.id.to_gene:
                GeneActivity.startAction(this);
                break;
            case R.id.next_one:
                startNext();
                break;
        }
    }
}