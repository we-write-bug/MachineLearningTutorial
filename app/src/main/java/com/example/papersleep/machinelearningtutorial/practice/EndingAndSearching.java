package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class EndingAndSearching extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_and_searching);
        Button reStart = findViewById(R.id.re_start);
        Button reFight = findViewById(R.id.re_fight);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.end_title);
        reStart.setOnClickListener(this);
        reFight.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, EndingAndSearching.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.re_fight:
                FightIt.startAction(this);
                break;
            case R.id.re_start:
                PracticeActivity.startAction(this);
                break;
        }
    }
}
