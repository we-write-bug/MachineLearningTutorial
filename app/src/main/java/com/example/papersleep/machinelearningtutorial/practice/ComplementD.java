package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.papersleep.machinelearningtutorial.MainActivity;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.tutorial.GeneActivity;

public class ComplementD extends BaseActivity {
    Button cont;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement_d);
        cont = findViewById(R.id.cont_d);

        cont.setOnClickListener(this);
        title = findViewById(R.id.title);

        title.setText("开发人员");
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, ComplementD.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cont_d:
                MainActivity.startAction(this);
                break;
        }
    }
}
