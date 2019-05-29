package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class SpecificActivity extends BaseActivity {
    Button button;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);

        button = findViewById(R.id.coding);
        title = findViewById(R.id.title);

        button.setOnClickListener(this);
        title.setText("遗传算法");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coding:
                CodingActivity.startAction(this);
                break;
        }
    }


    public static void startAction(Context context) {
        Intent intent = new Intent(context, SpecificActivity.class);
        context.startActivity(intent);
    }
}


