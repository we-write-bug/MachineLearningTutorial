package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class Evolution extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolution);
        Button toFight = findViewById(R.id.to_fight);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.evo_title);
        toFight.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, Evolution.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_fight:
                FightIt.startAction(this);
                break;
        }
    }
}
