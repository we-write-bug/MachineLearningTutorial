package com.example.papersleep.machinelearningtutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class PracticeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,PracticeActivity.class);
        context.startActivity(intent);
    }
}
