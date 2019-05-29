package com.example.papersleep.machinelearningtutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.papersleep.machinelearningtutorial.More.MoreActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.PracticeActivity;
import com.example.papersleep.machinelearningtutorial.tutorial.TutorialActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.cover_tutorial);
        Button button2 = findViewById(R.id.cover_practice);
        Button button3 = findViewById(R.id.more);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cover_tutorial:
                TutorialActivity.startAction(this);
                break;
            case R.id.cover_practice:
                PracticeActivity.startAction(this);
                break;
            case  R.id.more:
                MoreActivity.startAction(this);
                break;
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
