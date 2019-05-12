package com.example.papersleep.machinelearningtutorial.not_activity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.papersleep.machinelearningtutorial.R;

public class MyActionBar extends LinearLayout implements View.OnClickListener {
    public MyActionBar(Context context, AttributeSet attr) {
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.action_bar, this);
        Button back = findViewById(R.id.bar_back);
        Button next = findViewById(R.id.bar_next);
        back.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_back:
                ((Activity) this.getContext()).finish();
            case R.id.bar_next:

        }
    }
}
