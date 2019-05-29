package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class TutorialActivity extends BaseActivity  {
    Button button1;
    Button button2;
    ImageView arrow1;
    ImageView arrow2;
    TextView explain1;
    TextView explain2;
    TextView title;
    Integer times=0;
    ImageView bg;
    ImageButton barHelp;
    ImageButton barBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        barBack=findViewById(R.id.bar_back);
        barHelp=findViewById(R.id.bar_help);
        button1 = findViewById(R.id.start);
        button2 = findViewById(R.id.understand);
        title=findViewById(R.id.title);
        bg=findViewById(R.id.bg);
        arrow1=findViewById(R.id.arrow1);
        arrow2=findViewById(R.id.arrow2);
        explain1=findViewById(R.id.explain_bulb);
        explain2=findViewById(R.id.explain_arrow);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        title.setText("");
        barHelp.setEnabled(false);
        barBack.setEnabled(false);
        explain2.setVisibility(View.INVISIBLE);
        arrow2.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.understand:
                times++;
                if(times==1){
                    explain1.setVisibility(View.INVISIBLE);
                    arrow1.setVisibility(View.INVISIBLE);
                    explain2.setVisibility(View.VISIBLE);
                    arrow2.setVisibility(View.VISIBLE);
                }
                if(times==2){
                    explain2.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    bg.setVisibility(View.GONE);
                    barHelp.setEnabled(true);
                    barBack.setEnabled(true);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.start:
                DilemmaActivity.startAction(this);
        }
    }



    public static void startAction(Context context){
        Intent intent = new Intent(context,TutorialActivity.class);
        context.startActivity(intent);
    }
}
