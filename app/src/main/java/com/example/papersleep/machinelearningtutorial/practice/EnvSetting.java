package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;

public class EnvSetting extends BaseActivity implements OnSeekBarChangeListener {
    private Button toFunc;
    private TextView title;
    private TextView introR;
    private TextView value;
    private SeekBar seekBar;
    private ImageView bigR;
    private ImageView r1;
    private ImageView r2;
    private ImageView r3;
    private ImageView r4;
    private ImageView r5;
    private ImageView r6;
    private ImageView r7;
    private ImageView r8;
    Integer num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env_setting);
        seekBar = findViewById(R.id.env_roll);
        toFunc = findViewById(R.id.to_func);
        title = findViewById(R.id.title);
        introR = findViewById(R.id.intro_r);
        bigR = findViewById(R.id.big_r);
        value = findViewById(R.id.num_show);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        r7 = findViewById(R.id.r7);
        r8 = findViewById(R.id.r8);

        toFunc.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        r5.setOnClickListener(this);
        r6.setOnClickListener(this);
        r7.setOnClickListener(this);
        r8.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(this);

        title.setText(R.string.setting_title);

    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, EnvSetting.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_func:
                FuncSetting.startAction(this);
                break;
            case R.id.r1:
                seekBar.setProgress(0);
                num = 1;
                break;
            case R.id.r2:
                num = 2;
                break;
            case R.id.r3:
                num = 3;
                break;
            case R.id.r4:
                num = 4;
                break;
            case R.id.r5:
                num = 5;
                break;
            case R.id.r6:
                num = 6;
                break;
            case R.id.r7:
                num = 7;
                break;
            case R.id.r8:
                num = 8;
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String n = Integer.valueOf(progress).toString();
        value.setText(n);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        num = seekBar.getProgress();
    }

}
