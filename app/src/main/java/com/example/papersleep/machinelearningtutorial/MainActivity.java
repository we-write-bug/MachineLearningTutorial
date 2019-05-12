package com.example.papersleep.machinelearningtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.PracticeActivity;
import com.example.papersleep.machinelearningtutorial.tutorial.TutorialActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.cover_tutorial);
        Button button2 = findViewById(R.id.cover_practice);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cover_tutorial:
                TutorialActivity.startAction(this);
                Toast.makeText(this,"Xixi",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cover_practice:
                PracticeActivity.startAction(this);
                break;
        }
    }
}
