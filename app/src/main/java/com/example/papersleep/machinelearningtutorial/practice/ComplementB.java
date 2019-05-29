package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class ComplementB extends BaseActivity {
    Button cont;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement_b);
        cont = findViewById(R.id.cont_b);
        cont.setOnClickListener(this);
        title = findViewById(R.id.title);
        title.setText("拓展内容2");
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, ComplementB.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cont_b:
                AfterBActivity.startAction(this);
                break;
        }
    }
}
