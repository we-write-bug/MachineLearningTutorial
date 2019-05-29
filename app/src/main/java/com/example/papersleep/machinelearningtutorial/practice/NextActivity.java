package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.papersleep.machinelearningtutorial.R;

public class NextActivity extends AppCompatActivity {
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        title = findViewById(R.id.title);
        title.setText("hh");
    }
    public static void startAction(Context context) {
            Intent intent = new Intent(context, NextActivity.class);
            context.startActivity(intent);
        }
    }

