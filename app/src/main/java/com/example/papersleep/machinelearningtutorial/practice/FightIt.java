package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class FightIt extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_it);
        Button ally = findViewById(R.id.ally);
        Button betray = findViewById(R.id.betray);
        Button toEnd = findViewById(R.id.to_end);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.fight_title);
        ally.setOnClickListener(this);
        betray.setOnClickListener(this);
        toEnd.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, FightIt.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ally:
                findViewById(R.id.ally).setVisibility(View.GONE);
                findViewById(R.id.betray).setVisibility(View.GONE);
                findViewById(R.id.to_end).setVisibility(View.VISIBLE);
                break;
            case R.id.betray:
                break;
            case R.id.to_end:
                EndingAndSearching.startAction(this);
                break;
        }
    }
}
