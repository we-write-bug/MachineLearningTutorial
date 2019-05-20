package com.example.papersleep.machinelearningtutorial.not_activity;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    public int httpUrlConnPost(Map map) {
        HttpURLConnection urlConnection = null;
        int result = 0;
        try {
            URL url = new URL("http://172.27.133.198:8080/ELweb/EL");
            urlConnection = (HttpURLConnection) url.openConnection();//打开http连接
            urlConnection.setConnectTimeout(5000);//连接的超时时间
            urlConnection.setUseCaches(false);//不使用缓存
            //urlConnection.setFollowRedirects(false);是static函数，作用于所有的URLConnection对象。
            urlConnection.setInstanceFollowRedirects(true);//是成员函数，仅作用于当前函数,设置这个连接是否可以被重定向
            urlConnection.setReadTimeout(3000);//响应的超时时间
            urlConnection.setDoInput(true);//设置这个连接是否可以写入数据
            urlConnection.setDoOutput(true);//设置这个连接是否可以输出数据
            urlConnection.setRequestMethod("POST");//设置请求的方式
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");//设置消息的类型
            urlConnection.connect();// 连接，从上述至此的配置必须要在connect之前完成，实际上它只是建立了一个与服务器的TCP连接
            JSONObject json = new JSONObject(map);//创建json对象
            String jsonStr = json.toString();//把JSON对象按JSON的编码格式转换为字符串
            //------------字符流写入数据------------
            OutputStream out = urlConnection.getOutputStream();//输出流，用来发送请求，http请求实际上直到这个函数里面才正式发送出去
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));//创建字符流对象并用高效缓冲流包装它，便获得最高的效率,发送的是字符串推荐用字符流，其它数据就用字节流
            bw.write(jsonStr);//把json字符串写入缓冲区中
            bw.flush();//刷新缓冲区，把数据发送出去，这步很重要
            out.close();
            bw.close();//使用完关闭
            System.out.println("Successfully send data!");
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {//得到服务端的返回码是否连接成功
                //------------字符流读取服务端返回的数据------------
                InputStream in = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String str;
                StringBuffer buffer = new StringBuffer();
                while ((str = br.readLine()) != null) {//BufferedReader特有功能，一次读取一行数据
                    buffer.append(str);
                }
                in.close();
                br.close();
                System.out.println("Successfully accept data!");
                result = Integer.parseInt(buffer.toString());

            } else {
                System.out.println("请稍后");  //但好像不能这么写 用什么handle send message
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();//使用完关闭TCP连接，释放资源
        }
        return result;
    }
}
