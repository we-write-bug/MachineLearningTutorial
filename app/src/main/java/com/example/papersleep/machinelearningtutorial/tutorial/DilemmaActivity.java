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

public class DilemmaActivity extends BaseActivity {
    Button button2;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilemma);

        button2 = findViewById(R.id.rule);
        title = findViewById(R.id.title);

        button2.setOnClickListener(this);
        title.setText("囚徒困境");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rule:
                RuleActivity.startAction(this);
                break;
        }
    }

    public static void startAction(Context context){
        Intent intent = new Intent(context,DilemmaActivity.class);
        context.startActivity(intent);
    }
}
