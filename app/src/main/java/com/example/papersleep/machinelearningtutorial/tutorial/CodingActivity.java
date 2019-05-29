package com.example.papersleep.machinelearningtutorial.tutorial;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CodingActivity extends BaseActivity {
    Button button;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding);
        button = findViewById(R.id.chromosome);
        title = findViewById(R.id.title);

        button.setOnClickListener(this);
        title.setText("遗传算法");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chromosome:
                ChromosomeActivity.startAction(this);
                break;
        }
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,CodingActivity.class);
        context.startActivity(intent);
    }
}
