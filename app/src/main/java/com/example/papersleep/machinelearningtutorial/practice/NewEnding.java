package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.Evolution.GameCenter;
import com.example.papersleep.machinelearningtutorial.Evolution.Pop;
import com.example.papersleep.machinelearningtutorial.Evolution.UserPop;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;

import java.util.HashMap;
import java.util.Map;

public class NewEnding extends BaseActivity {
    Button toC;
    TextView title;
    TextView myEndScore;
    TextView popEndScore;
    TextView popNewEndScore;

    static int yourS = 5;
    static int yourMS = 5;
    static int yourNMS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ending);

        title = findViewById(R.id.title);
        myEndScore = findViewById(R.id.my_end_score);
        popEndScore = findViewById(R.id.pop_end_score);
        popNewEndScore=findViewById(R.id.pop_new_end_score);
        toC=findViewById(R.id.to_c);

        title.setText(R.string.end_title);
        myEndScore.setText(String.format(getString(R.string.my_end_score), yourS));
        popEndScore.setText(String.format(getString(R.string.pop_end_score), yourMS));
        popNewEndScore.setText(String.format("更优进化策略下的得分是 %d", yourNMS));
        toC.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, NewEnding.class);
        context.startActivity(intent);

        //TODO:modified
        yourMS = DataCollector.new_end_yourms;
        yourS = DataCollector.new_end_yours;
        yourNMS = DataCollector.new_end_yournms;
    }

    public static Map getSetting() {
        Map setting = new HashMap();
        for (int i = 1; i <= 8; i++)
            setting.put(i, 6 + (int) (Math.random() * 5));
        return setting;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_c:
                ComplementC.startAction(this);
                break;
        }
    }
}
