package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;

import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.inquiryOut;

public class Inquiry extends BaseActivity {
    Button ally1;
    Button ally2;
    Button ally3;
    Button ally4;
    Button ally5;
    Button betray1;
    Button betray2;
    Button betray3;
    Button betray4;
    Button betray5;
    Button wantB;
    Button toEnd;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        ally1 = findViewById(R.id.ally1);
        ally2 = findViewById(R.id.ally2);
        ally3 = findViewById(R.id.ally3);
        ally4 = findViewById(R.id.ally4);
        ally5 = findViewById(R.id.ally5);
        betray1 = findViewById(R.id.betray1);
        betray2 = findViewById(R.id.betray2);
        betray3 = findViewById(R.id.betray3);
        betray4 = findViewById(R.id.betray4);
        betray5 = findViewById(R.id.betray5);

        toEnd = findViewById(R.id.to_gene);

        ally1.setOnClickListener(this);
        ally2.setOnClickListener(this);
        ally3.setOnClickListener(this);
        ally4.setOnClickListener(this);
        ally5.setOnClickListener(this);
        betray1.setOnClickListener(this);
        betray2.setOnClickListener(this);
        betray3.setOnClickListener(this);
        betray4.setOnClickListener(this);
        betray5.setOnClickListener(this);
        toEnd.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        if (inquiryOut) {
            EndingAndSearching.startAction(context, Inquiry.class);
            return;
        }
        Intent intent = new Intent(context, Inquiry.class);
        context.startActivity(intent);
    }

    public static void clear() {
        for (int i = 0; i < 5; i++) DataCollector.inquiry[i] = 0;
        inquiryOut = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ally1:
                DataCollector.inquiry[0] = 1;
                break;
            case R.id.ally2:
                DataCollector.inquiry[1] = 1;
                break;
            case R.id.ally3:
                DataCollector.inquiry[2] = 1;
                break;
            case R.id.ally4:
                DataCollector.inquiry[3] = 1;
                break;
            case R.id.ally5:
                DataCollector.inquiry[4] = 1;
                break;

            case R.id.betray1:
                DataCollector.inquiry[0] = 0;
                break;
            case R.id.betray2:
                DataCollector.inquiry[1] = 0;
                break;
            case R.id.betray3:
                DataCollector.inquiry[2] = 0;
                break;
            case R.id.betray4:
                DataCollector.inquiry[3] = 0;
                break;
            case R.id.betray5:
                DataCollector.inquiry[4] = 0;
                break;
            case R.id.to_gene:
                inquiryOut = true;
                EndingAndSearching.startAction(this, Inquiry.class);
                break;
        }
    }
}
