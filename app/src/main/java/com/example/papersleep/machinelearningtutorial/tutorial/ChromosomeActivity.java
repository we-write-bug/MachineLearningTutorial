package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;


public class ChromosomeActivity extends BaseActivity {
    Button button;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chromosome);

        button = findViewById(R.id.evolution);
        title = findViewById(R.id.title);

        button.setOnClickListener(this);
        title.setText("染色体/适应度");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.evolution:
                T_EvolutionActivity.startAction(this);
                break;
        }
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, ChromosomeActivity.class);
        context.startActivity(intent);
    }
}
