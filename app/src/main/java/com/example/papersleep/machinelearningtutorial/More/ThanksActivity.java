package com.example.papersleep.machinelearningtutorial.More;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.practice.PracticeActivity;


public class ThanksActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
    }
    public static void startAction(Context context) {
        Intent intent = new Intent(context, ThanksActivity.class);
        context.startActivity(intent);
    }
}
