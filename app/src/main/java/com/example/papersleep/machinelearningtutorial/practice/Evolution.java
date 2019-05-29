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
import com.example.papersleep.machinelearningtutorial.view.LoadingActivity;
import java.util.ArrayList;
import java.util.Comparator;
import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.*;
public class Evolution extends BaseActivity {
    String result="";
    Button toInquiry;
    Button showRes;
    TextView title;
    TextView score;
    TextView top_score;
    ActionBar bar;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolution);
        LoadingActivity.startAction(this,getClass());
        top_score=findViewById(R.id.top_score);
        score = findViewById(R.id.score);
        toInquiry = findViewById(R.id.to_inquiry);
        showRes = findViewById(R.id.show_res);
        title = findViewById(R.id.title);

        title.setText(R.string.evo_title);
        toInquiry.setOnClickListener(this);
        showRes.setOnClickListener(this);
//        score.setText(String.format("%d", forTest));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void startAction(Context context) {
//        new Thread(() -> forTest = httpUrlConnPost(toMap())).start();
        Intent toEvo = new Intent(context, Evolution.class);
        context.startActivity(toEvo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_inquiry:
                Inquiry.startAction(this);
                break;
            case R.id.show_res:
                for (int i = 0; i < scores.size(); i++){
                    result=result+"\n"+String.format(getString(R.string.score_info), i + 1, scores.get(i));
                }
                score.setText(result);
                top_score.setText(String.format(("FINAL: %d"),scoreFinal));


//                score.setText(String.format(getString(R.string.score_info), 1, forTest));
                showRes.setVisibility(View.GONE);
                toInquiry.setVisibility(View.VISIBLE);
                break;
        }
    }
}
