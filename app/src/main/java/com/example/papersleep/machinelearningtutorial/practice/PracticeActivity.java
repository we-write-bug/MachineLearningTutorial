package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.ActivityCollector;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;


public class PracticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        ActivityCollector.addActivity(this);
        Button toEnv = findViewById(R.id.to_env);
        ImageButton help = findViewById(R.id.bar_help);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.practice);
        toEnv.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, PracticeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_env:
                EnvSetting.startAction(this);
                break;
            case R.id.bar_help:
                Toast.makeText(PracticeActivity.this,"Yeah",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
