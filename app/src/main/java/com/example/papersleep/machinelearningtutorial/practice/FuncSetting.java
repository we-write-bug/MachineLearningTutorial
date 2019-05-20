package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class FuncSetting extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_func_setting);
        Button toEvo = findViewById(R.id.to_evo);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.setting_title);
        toEvo.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, FuncSetting.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_evo:
                Evolution.startAction(this);
                break;
        }
    }
}
