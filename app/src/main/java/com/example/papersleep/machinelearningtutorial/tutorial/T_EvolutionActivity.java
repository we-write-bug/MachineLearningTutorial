package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class T_EvolutionActivity extends BaseActivity {
    Button button;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_evolution);
        button = findViewById(R.id.select);
        title = findViewById(R.id.title);

        button.setOnClickListener(this);
        title.setText("进化");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select:
                SelectActivity.startAction(this);
                break;
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, T_EvolutionActivity.class);
        context.startActivity(intent);
    }
}
