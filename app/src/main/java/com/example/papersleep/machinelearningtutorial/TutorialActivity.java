package com.example.papersleep.machinelearningtutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class TutorialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,TutorialActivity.class);
        context.startActivity(intent);
    }
}
