package com.example.papersleep.machinelearningtutorial.practice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.ActivityCollcetor;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;

public class PracticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        ActivityCollcetor.addActivity(this);
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,PracticeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        ActivityCollcetor.removeActivity(this);
        super.onDestroy();
    }
}
