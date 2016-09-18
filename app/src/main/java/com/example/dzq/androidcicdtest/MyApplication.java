package com.example.dzq.androidcicdtest;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dzq on 16/9/18.
 */
public class MyApplication extends Application {
    public static ConfigModel appConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化App配置从assets中的config中读取
        appConfig = new Gson().fromJson(readText(this,"config.json"),ConfigModel.class);
    }


    //从assets中读取文件返回字符串
    public String readText(Context context, String assetPath) {
        try {
            return toString(context.getAssets().open(assetPath));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String toString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
