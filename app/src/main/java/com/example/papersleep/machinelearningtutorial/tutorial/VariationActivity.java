package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.PracticeActivity;
import com.example.papersleep.machinelearningtutorial.view.LoadingActivity;

public class VariationActivity extends BaseActivity {
    Button button;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variation);

        button = findViewById(R.id.actual);
        title = findViewById(R.id.title);

        button.setOnClickListener(this);
        title.setText("交叉/变异");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actual:
                PracticeActivity.startAction(this);
                LoadingActivity.startAction(this, PracticeActivity.class);
                break;
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, VariationActivity.class);
        context.startActivity(intent);
    }
}
