package com.example.dzq.androidcicdtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView helloTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTv = (TextView) findViewById(R.id.hello_tv);

        helloTv.setText("hello\n" + "api_endpoint:" + MyApplication.appConfig.api_endpoint
                + "\n test_id:" + MyApplication.appConfig.test_id);
    }
}
