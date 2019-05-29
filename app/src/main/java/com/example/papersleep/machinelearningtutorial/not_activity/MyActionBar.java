package com.example.papersleep.machinelearningtutorial.not_activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.example.papersleep.machinelearningtutorial.MainActivity;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.tutorial.Explanation;
public class MyActionBar extends LinearLayout implements View.OnClickListener {
    public MyActionBar(Context context, AttributeSet attr) {
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.action_bar, this);
        ImageButton back = findViewById(R.id.bar_back);
        ImageButton help = findViewById(R.id.bar_help);
        back.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_back:
                MainActivity.startAction(getContext());
                break;
            case R.id.bar_help:
                Explanation.startAction(getContext(),getContext().getClass());
                break;
        }
    }
}
