package com.example.papersleep.machinelearningtutorial.tutorial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import android.widget.ImageView;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class GeneActivity extends BaseActivity {
    Button button;
    TextView title;
    Integer times=0;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gene);

        button = findViewById(R.id.specific);
        title = findViewById(R.id.title);
        button.setOnClickListener(this);
        title.setText("遗传算法");
        img=findViewById(R.id.dashixiong);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.specific:
                if(times==0){
                    img.setImageResource(R.drawable.ex_group2);
                    times++;
                }else {
                    times=0;
                    SpecificActivity.startAction(this);
                }
                break;
        }
    }


    public static void startAction(Context context) {
        Intent intent = new Intent(context, GeneActivity.class);
        context.startActivity(intent);
    }
}
