package com.example.papersleep.machinelearningtutorial.not_activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.example.papersleep.machinelearningtutorial.R;

public class MyActionBar extends LinearLayout {
    public MyActionBar(Context context, AttributeSet attr){
        super(context,attr);
        LayoutInflater.from(context).inflate(R.layout.action_bar,this);
    }
}
