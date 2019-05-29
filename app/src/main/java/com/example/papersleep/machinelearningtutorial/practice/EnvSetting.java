package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;
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
    Integer id = 1;

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

        title.setText("选择陪练机器人");

    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, EnvSetting.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.r1:
                id = 1;
                seekBar.setProgress(DataCollector.nums[0]);
                bigR.setImageResource(R.drawable.ca);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r2:
                id = 2;
                seekBar.setProgress(DataCollector.nums[1]);
                bigR.setImageResource(R.drawable.im);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r3:
                id = 3;
                seekBar.setProgress(DataCollector.nums[2]);
                bigR.setImageResource(R.drawable.fury);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r4:
                id = 4;
                seekBar.setProgress(DataCollector.nums[3]);
                bigR.setImageResource(R.drawable.hulk);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r5:
                id = 5;
                seekBar.setProgress(DataCollector.nums[4]);
                bigR.setImageResource(R.drawable.thor);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r6:
                id = 6;
                seekBar.setProgress(DataCollector.nums[5]);
                bigR.setImageResource(R.drawable.groot);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r7:
                id = 7;
                seekBar.setProgress(DataCollector.nums[6]);
                bigR.setImageResource(R.drawable.spider);
                introR.setText(R.string.setting_title);
                break;
            case R.id.r8:
                id = 8;
                seekBar.setProgress(DataCollector.nums[7]);
                bigR.setImageResource(R.drawable.panther);
                introR.setText(R.string.setting_title);
                break;
            case R.id.to_func:
                FuncSetting.startAction(this);
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
        DataCollector.nums[id - 1] = seekBar.getProgress();
        if(DataCollector.nums[0]>0){
            r1.setBackgroundResource(R.drawable.ca_choose);
        }else {
            r1.setBackgroundResource(R.drawable.ca);
        }
        if(DataCollector.nums[1]>0){
            r2.setBackgroundResource(R.drawable.im_choose);
        }else {
            r2.setBackgroundResource(R.drawable.im);
        }
        if(DataCollector.nums[2]>0){
            r3.setBackgroundResource(R.drawable.fury_choose);
        }else {
            r3.setBackgroundResource(R.drawable.fury);
        }if(DataCollector.nums[3]>0){
            r4.setBackgroundResource(R.drawable.hulk_choose);
        }else {
            r4.setBackgroundResource(R.drawable.hulk);
        }if(DataCollector.nums[4]>0){
            r5.setBackgroundResource(R.drawable.thor_choose);
        }else {
            r5.setBackgroundResource(R.drawable.thor);
        }if(DataCollector.nums[5]>0){
            r6.setBackgroundResource(R.drawable.groot_choose);
        }else {
            r6.setBackgroundResource(R.drawable.groot);
        }if(DataCollector.nums[6]>0){
            r7.setBackgroundResource(R.drawable.spider_choose);
        }else {
            r7.setBackgroundResource(R.drawable.spider);
        }if(DataCollector.nums[7]>0){
            r8.setBackgroundResource(R.drawable.panther_choose);
        }else {
            r8.setBackgroundResource(R.drawable.panther);
        }
    }
}
