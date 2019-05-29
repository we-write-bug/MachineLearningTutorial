package com.example.papersleep.machinelearningtutorial.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.papersleep.machinelearningtutorial.More.MoreActivity;
import com.example.papersleep.machinelearningtutorial.More.OnlineFightActivity;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.Robot.*;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;
import com.example.papersleep.machinelearningtutorial.not_activity.NetworkCollector;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Random;

import static com.example.papersleep.machinelearningtutorial.not_activity.MyClients.submit;
import static com.example.papersleep.machinelearningtutorial.not_activity.NetworkCollector.x;

public class RecycleFight extends BaseActivity {
    Button ally, betray, toEAS, nextOne;
    TextView title, yourS, itsS, finalRes, yourName, itsName;
    ImageView you, it, yourC, itsC, comRes;

    Integer times = 0;
    Integer yourScore = 0;
    Integer totalScore = 0;
    Integer itsScore = 0;
    Integer currentId = 0;

    Robot[] robotSet = new Robot[8];
    ArrayList robot = new ArrayList();
    Robot currentR;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message m) {
            if (m.what == 1) {
                oppoName = (String) m.obj;
            }
        }
    };

    static String oppoName;

    public static Class from;

    static int LIMIT = 40;

    @SuppressLint("DefaultLocale")
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
        toEAS = findViewById(R.id.to_eas);
        nextOne = findViewById(R.id.next_one);
        title = findViewById(R.id.title);
        yourC = findViewById(R.id.your_c);
        itsC = findViewById(R.id.its_c);
        you = findViewById(R.id.you);
        it = findViewById(R.id.it);
        yourS = findViewById(R.id.your_s);
        itsS = findViewById(R.id.its_s);
        yourName = findViewById(R.id.your_n);
        itsName = findViewById(R.id.its_n);
        comRes = findViewById(R.id.com_res);
        finalRes = findViewById(R.id.final_res);

        title.setText("再打一架");
        yourS.setText(String.format("Your score:\n%d", yourScore));
        itsS.setText(String.format("Its score:\n%d", itsScore));
        yourName.setText("你");
        ally.setOnClickListener(this);
        betray.setOnClickListener(this);
        toEAS.setOnClickListener(this);
        nextOne.setOnClickListener(this);
        comRes.setImageResource(R.drawable.xx);
        startNext();
    }

    @Override
    protected void onResume() {
        super.onResume();
        times = 0;
        yourScore = 0;
        totalScore = 0;
        itsScore = 0;
        currentId = 0;
    }

    public static void startAction(Context context, Class from) {
        RecycleFight.from = from;
        Intent intent = new Intent(context, RecycleFight.class);
        context.startActivity(intent);
    }

    public void randomRobot() {
        currentId = new Random().nextInt(8);
        while (robot.contains(currentId))
            currentId = new Random().nextInt(8);
        robot.add(currentId);
        currentR = robotSet[currentId];
        it.setImageResource(currentId == 0 ? R.drawable.ca :
                currentId == 1 ? R.drawable.im :
                        currentId == 2 ? R.drawable.fury :
                                currentId == 3 ? R.drawable.hulk :
                                        currentId == 4 ? R.drawable.thor :
                                                currentId == 5 ? R.drawable.groot :
                                                        currentId == 6 ? R.drawable.spider :
                                                                R.drawable.panther);
    }

    @SuppressLint("DefaultLocale")
    public void startNext() {
        if (from == OnlineFightActivity.class) {
            String temp;
            new Thread(() -> {
                while (!x.receive().equals("成员到齐！")) ;
                Message m = Message.obtain();
                m.obj = x.receive();
                m.what = 1;
                handler.sendMessage(m);
            }).start();
            yourName.setVisibility(View.VISIBLE);
        } else {
            randomRobot();
            yourName.setVisibility(View.INVISIBLE);
        }

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
        if (from == MoreActivity.class) {
            totalScore += yourScore;
            findViewById(R.id.ally).setVisibility(View.GONE);
            findViewById(R.id.betray).setVisibility(View.GONE);
            nextOne.setVisibility(View.VISIBLE);
        } else {
            totalScore += yourScore * (Integer) EndingAndSearching.workEnv.get(currentId + 1);
            findViewById(R.id.ally).setVisibility(View.GONE);
            findViewById(R.id.betray).setVisibility(View.GONE);
            nextOne.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("DefaultLocale")
    public void battleTest(int choosee, int choose) {
        comRes.setImageResource
                (choose == 0 && choosee == 0 ? R.drawable.bb :
                        choose == 0 && choosee == 1 ? R.drawable.ba :
                                choose == 1 && choosee == 0 ? R.drawable.ab :
                                        R.drawable.aa);
        yourScore +=
                (choose == 0 && choosee == 0 ? 1 :
                        choose == 0 && choosee == 1 ? 3 :
                                choose == 1 && choosee == 0 ? 0 : 2);
        itsScore +=
                (choose == 0 && choosee == 0 ? 1 :
                        choose == 0 && choosee == 1 ? 0 :
                                choose == 1 && choosee == 0 ? 3 : 2);

        yourS.setText(String.format("Your score:\n%d", yourScore));
        itsS.setText(String.format("Its score:\n%d", itsScore));

        times++;
        if (times % 5 == 0) endThis();
        if (times == LIMIT) {
            DataCollector.total = totalScore;
            nextOne.setVisibility(View.GONE);
            comRes.setVisibility(View.GONE);
            itsC.setVisibility(View.GONE);
            yourC.setVisibility(View.GONE);
            finalRes.setVisibility(View.VISIBLE);
            toEAS.setVisibility(View.VISIBLE);
            finalRes.setText(String.format("你的总分为 %d", totalScore));
        }
    }

    public void battleTest(Robot r, int choose) {
        int _choice = r.calculate(choose);
        battleTest(_choice, choose);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ally:
                if (from == OnlineFightActivity.class)
                    battleTest(submit(1, NetworkCollector.x), 1);
                else battleTest(currentR, 1);
                break;
            case R.id.betray:
                if (from == OnlineFightActivity.class)
                    battleTest(submit(0, NetworkCollector.x), 0);
                else battleTest(currentR, 0);
                break;
            case R.id.next_one:
                startNext();
                break;
            case R.id.to_eas:
                if (from == MoreActivity.class)
                    MoreActivity.startAction(this);
                else
                    EndingAndSearching.startAction(this, RecycleFight.class);
                break;
        }
    }
}