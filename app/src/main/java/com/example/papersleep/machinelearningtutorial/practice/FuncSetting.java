package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.*;

public class FuncSetting extends BaseActivity {
    Button toEvo;
    Button select1;
    Button select2;
    Button select3;
    Button select4;
    Button cross1;
    Button cross2;
    Button funMajor;
    Button funMinor;
    TextView title;
    RadioGroup group1;
    RadioGroup group2;
    Button select_cross;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_func_setting);
        toEvo = findViewById(R.id.to_other);
        group1=findViewById(R.id.select);
        group2=findViewById(R.id.cross);
        select1 = findViewById(R.id.select1);
        select2 = findViewById(R.id.select2);
        select3 = findViewById(R.id.select3);
        select4 = findViewById(R.id.select4);
        cross1 = findViewById(R.id.cross1);
        cross2 = findViewById(R.id.cross2);
        title = findViewById(R.id.title);
        select_cross=findViewById(R.id.select_cross);

        title.setText("选择/交叉策略");
        select1.setOnClickListener(this);
        select2.setOnClickListener(this);
        select3.setOnClickListener(this);
        select4.setOnClickListener(this);
        cross1.setOnClickListener(this);
        cross2.setOnClickListener(this);
        toEvo.setOnClickListener(this);
        select_cross.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, FuncSetting.class);
        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_other:
                IterMutaSetting.startAction(this);
                break;
            case R.id.select1:
                choose = 1;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select2:
                choose = 2;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select3:
                choose = 3;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select4:
                choose = 4;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cross1:
                cross = 1;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cross2:
                cross = 2;
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.select_cross:
                group1.setVisibility(View.GONE);
                group2.setVisibility(View.VISIBLE);
                select_cross.setVisibility(View.GONE);
                toEvo.setVisibility(View.VISIBLE);
        }
    }
}
