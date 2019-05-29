package com.example.papersleep.machinelearningtutorial.view;
import android.content.Context;
import android.content.Intent;
import com.example.papersleep.machinelearningtutorial.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;
public class ProgressActivity extends AppCompatActivity {
    private CustomHorizontalProgresWithNum horizontalProgress2;//水平带进度

    private Timer timer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        horizontalProgress2 =  findViewById(R.id.horizontalProgress2);

        horizontalProgress2.setProgress(0);
        horizontalProgress2.setMax(100);


        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                //实时更新进度
                if (horizontalProgress2.getProgress() >= 100) {//指定时间取消
                    timer2.cancel();
                }
                horizontalProgress2.setProgress(horizontalProgress2.getProgress() + 1);

            }
        }, 20, 20);


    }
    public static void startAction(Context context) {
        Intent intent = new Intent(context, ProgressActivity.class);
        context.startActivity(intent);
    }
}