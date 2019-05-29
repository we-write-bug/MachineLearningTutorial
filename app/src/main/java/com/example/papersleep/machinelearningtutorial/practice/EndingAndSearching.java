package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.Evolution.GameCenter;
import com.example.papersleep.machinelearningtutorial.Evolution.UserPop;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.*;

public class EndingAndSearching extends BaseActivity {
    Button reEvo;
    Button reInquiry;
    Button ICan;
    Button toNext;
    TextView title;
    TextView myEndScore;
    TextView popEndScore;
    static int yourS = 5;
    static int yourMS = 5;
    static Class from;
    static Map workEnv;

    static {
        envSetting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_and_searching);

        reEvo = findViewById(R.id.re_evo);
        reInquiry = findViewById(R.id.re_inquiry);
        title = findViewById(R.id.title);
        myEndScore = findViewById(R.id.my_end_score);
        popEndScore = findViewById(R.id.pop_end_score);
        ICan = findViewById(R.id.i_can);
        toNext = findViewById(R.id.to_next);

        if (from == RecycleFight.class) {
            reEvo.setVisibility(View.GONE);
            reInquiry.setVisibility(View.GONE);
        }

        title.setText(R.string.end_title);

        reEvo.setOnClickListener(this);
        reInquiry.setOnClickListener(this);
        ICan.setOnClickListener(this);
        toNext.setOnClickListener(this);
    }

    public static void envSetting() {
        Map setting = new HashMap();
        for (int i = 1; i <= 8; i++)
            setting.put(i, 6 + (int) (Math.random() * 5));
        workEnv = setting;
        workenvir = setting;
    }

    @Override
    protected void onResume() {
        super.onResume();
        myEndScore.setText(String.format(getString(R.string.my_end_score), yourS));
        popEndScore.setText(String.format(getString(R.string.pop_end_score), yourMS));
    }

    public static void startAction(Context context, Class from) {
        EndingAndSearching.from = from;

        if (from == RecycleFight.class)
            yourS = total;
        else {
            yourMS = GameCenter.battle(bestOne, workEnv);
            yourS = GameCenter.battle(new UserPop(inquiry), workEnv);
            total = yourS;
        }

        Intent intent = new Intent(context, EndingAndSearching.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_next:
                ComplementA.startAction(this);
                break;
            case R.id.i_can:
                RecycleFight.startAction(this,this.getClass());
                break;
            case R.id.re_inquiry:
                Inquiry.clear();
                Inquiry.startAction(this);
                break;
            case R.id.re_evo:
                EnvSetting.startAction(this);
                break;
        }
    }
}
