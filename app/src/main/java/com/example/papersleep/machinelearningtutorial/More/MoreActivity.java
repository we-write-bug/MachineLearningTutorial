package com.example.papersleep.machinelearningtutorial.More;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.RecycleFight;


public class MoreActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        Button button1;
        Button button2;
        Button button3;
        button1=findViewById(R.id.online_fight);
        button2=findViewById(R.id.thanks);
        button3=findViewById(R.id.learn_more);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.online_fight:
                RecycleFight.startAction(this,this.getClass());
                break;
            case R.id.learn_more:
                LearnActivity.startAction(this);
                break;
            case  R.id.thanks:
                ThanksActivity.startAction(this);
                break;
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, MoreActivity.class);
        context.startActivity(intent);

    }



}
