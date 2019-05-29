package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;

public class IterMutaSetting extends BaseActivity implements SeekBar.OnSeekBarChangeListener {
    Button toEvo;
    SeekBar iterSeek;
    SeekBar mutateSeek;
    TextView iterNum;
    TextView mutateNum;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iter_mute_setting);
        toEvo = findViewById(R.id.to_evo);
        iterSeek = findViewById(R.id.iter_seek);
        mutateSeek = findViewById(R.id.mutate_seek);
        iterNum = findViewById(R.id.iter_num);
        mutateNum = findViewById(R.id.mutate_num);
        title = findViewById(R.id.title);

        title.setText("其他配置");
        iterNum.setText("50");
        mutateNum.setText("0.00");
        iterSeek.setOnSeekBarChangeListener(this);
        mutateSeek.setOnSeekBarChangeListener(this);
        toEvo.setOnClickListener(this);
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, IterMutaSetting.class);
        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_evo:
                Evolution.startAction(this);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.iter_seek:
                iterNum.setText(Integer.valueOf(progress + 50).toString());
                break;
            case R.id.mutate_seek:
                String n = String.format("%.2f",progress/100.0);
                mutateNum.setText(n);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.iter_seek:
                DataCollector.iteration = seekBar.getProgress() + 50;
                break;
            case R.id.mutate_seek:
                DataCollector.mutate = seekBar.getProgress() / 100.0;
                break;
        }
    }
}