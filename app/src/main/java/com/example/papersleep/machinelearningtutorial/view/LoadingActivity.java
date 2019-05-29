package com.example.papersleep.machinelearningtutorial.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.papersleep.machinelearningtutorial.Evolution.GameCenter;
import com.example.papersleep.machinelearningtutorial.Evolution.Pop;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.DataCollector;
import com.example.papersleep.machinelearningtutorial.practice.AfterBActivity;
import com.example.papersleep.machinelearningtutorial.practice.Evolution;
import com.example.papersleep.machinelearningtutorial.practice.NewEnding;

import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.*;

public class LoadingActivity extends BaseActivity {

    private static final long DELAY = 8000;
    static Class from;
    static final Boolean[] ready = {false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        WebView webview = findViewById(R.id.web);
        WebSettings wv_setting = webview.getSettings();
        wv_setting.setJavaScriptEnabled(true);
        String url = "file:///android_asset/calculate/index2.html";
        webview.loadUrl(url);
        final CustomHorizontalProgresWithNum horizontalProgress2;//水平带进度
        horizontalProgress2 = findViewById(R.id.horizontalProgress2);
        final Timer timer2;
        horizontalProgress2.setProgress(0);
        horizontalProgress2.setMax(600);


        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                //实时更新进度
                if (horizontalProgress2.getProgress() >= 600)
                    timer2.cancel();
                horizontalProgress2.setProgress(horizontalProgress2.getProgress() + 1);

            }
        }, 10, 10);
        final Intent localIntent = new Intent(this, from);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(localIntent);
            }
        };
        System.out.println("####ircle");
        timer.schedule(task, DELAY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (from==Evolution.class) {
            while (!ready[0]){}
        }else if (from==AfterBActivity.class){
            while (!ready[1]){
                System.out.println("###1");
            }
        }
    }

    public static void startAction(Context context, Class from) {
        LoadingActivity.from = from;
        Intent intent = new Intent(context, LoadingActivity.class);
        context.startActivity(intent);

        new Thread() {
            @Override
            public void run() {
                if (from == Evolution.class) {
                    ArrayList res = GameCenter.cultivatePlay(toMap());
                    scores = (ArrayList<Integer>) res.get(0);
                    bestOne = (Pop) res.get(1);
                    scoreFinal = bestOne.getScore();ready[0] = true;
                }else if(from==AfterBActivity.class){
                    Map m = DataCollector.workenvir;
                    DataCollector.new_end_yourms = GameCenter.battle(DataCollector.bestOne, m);
                    System.out.printf("***yourms");
                    DataCollector.new_end_yours = DataCollector.total==null?0:DataCollector.total;
                    System.out.printf("***yours");
//                    m = DataCollector.toMap();
                    m.put("Option",1);
                    m.put("Iteration",999);
                    m.put("Cross",2);
                    m.put("Mutation",0.1);
                    ArrayList res = GameCenter.betterCultivate(m);
                    DataCollector.new_bestOne=(Pop)res.get(1);
                    DataCollector.new_score_list = (ArrayList<Integer>) res.get(0);

                    DataCollector.new_end_yournms = GameCenter.battle(DataCollector.new_bestOne,DataCollector.workenvir);ready[1] = true;
                    System.out.printf("***yournms");
                }
            }
        }.start();
    }
}
