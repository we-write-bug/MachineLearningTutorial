package com.example.papersleep.machinelearningtutorial.practice;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.Evolution.*;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;
import com.example.papersleep.machinelearningtutorial.view.LoadingActivity;
import java.util.ArrayList;
import java.util.Comparator;
import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.*;
public class AfterBActivity extends BaseActivity {
    String result="";
    Button toComplementC;
    Button showRes;
    TextView title;
    TextView score;
    TextView topScore;
    ActionBar bar;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_b);
        LoadingActivity.startAction(this,getClass());
        //topScore显示最高分
        topScore=findViewById(R.id.topScore);
        //score显示每一代的分数
        score = findViewById(R.id.score);
        //toComplementC是跳到下一个C
        showRes=findViewById(R.id.show_res);
        toComplementC = findViewById(R.id.to_complementC);
        title = findViewById(R.id.title);
        title.setText(R.string.evo_title);
        toComplementC.setOnClickListener(this);
//        score.setText(String.format("%d", forTest));
        showRes.setOnClickListener(this);
        //刚开始把展示结果的这个按钮写成
        showRes.setVisibility(View.VISIBLE);
        toComplementC.setVisibility(View.GONE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void startAction(Context context) {
      Intent intent = new Intent(context, AfterBActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_res:
                for (int i = 0; i < DataCollector.new_score_list.size(); i++){
                    result=result+"\n"+String.format(getString(R.string.score_info), i + 1, DataCollector.new_score_list.get(i));
                }
                score.setText(result);
                topScore.setText(String.format(("FINAL: %d"),DataCollector.new_bestOne.getScore()));
//                score.setText(String.format(getString(R.string.score_info), 1, forTest));
                showRes.setVisibility(View.GONE);
                toComplementC.setVisibility(View.VISIBLE);
                break;
            case R.id.to_complementC:
                NewEnding.startAction(this);
        }
    }
}
