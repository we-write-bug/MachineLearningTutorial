package com.example.papersleep.machinelearningtutorial.More;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.papersleep.machinelearningtutorial.MainActivity;
import com.example.papersleep.machinelearningtutorial.R;
import com.example.papersleep.machinelearningtutorial.not_activity.BaseActivity;
import com.example.papersleep.machinelearningtutorial.not_activity.MyClients;
import com.example.papersleep.machinelearningtutorial.not_activity.NetworkCollector;
import com.example.papersleep.machinelearningtutorial.practice.RecycleFight;

import java.io.IOException;

import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.hName;
import static com.example.papersleep.machinelearningtutorial.not_activity.DataCollector.uName;

public class OnlineFightActivity extends BaseActivity {
    EditText user_name;
    EditText house_number;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_name = findViewById(R.id.user_name);
        house_number = findViewById(R.id.house_number);
        title = findViewById(R.id.title);
        Button button = findViewById(R.id.enter);
        button.setOnClickListener(this);
        title.setText("嘻一起开房嘻");
    }

    public static void startAction(Context context) {
        Intent intent = new Intent(context, OnlineFightActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter:
                if (user_name.getText().toString().equals("")) Toast.makeText(this, "请输入用户名", Toast.LENGTH_LONG).show();
                else if (house_number.getText().toString().equals(""))
                    Toast.makeText(this, "请输入房间名", Toast.LENGTH_LONG).show();
                else {
                    uName = user_name.getText().toString();
                    hName = house_number.getText().toString();

                    try {
                        if (MyClients.login(uName, hName, NetworkCollector.x)) {
                            Toast.makeText(this, "欢迎光临", Toast.LENGTH_LONG).show();
                            RecycleFight.startAction(this, this.getClass());
                        } else MainActivity.startAction(this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        }
    }
}
