package com.baway.day02.net;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Copyright (C), 2015-${YEAR}, 八维集团
 * Author: ${USER}
 * Date: ${DATE} ${TIME}
 * Description:封装网络工具类
 */
public class AnsyncHttpClient {
    private static final AnsyncHttpClient ourInstance = new AnsyncHttpClient();

    public static AnsyncHttpClient getInstance() {
        return ourInstance;
    }

    private AnsyncHttpClient() {
    }

    //异步请求
    public void getDataAsync(String url, final AsyncCallBack asyncCallBack){
        new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... strings) {
                return getDataFromServer(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)){
                    asyncCallBack.onSuccess(s);
                }else{
                    asyncCallBack.onError(2002);
                }
            }
        }.execute(url);
    }

    //请求网络
    private  String getDataFromServer(String url){

        HttpURLConnection connection=null;
        try {
            URL url1 = new URL(url);
            connection= (HttpURLConnection) url1.openConnection();
            //请求头
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            //判断
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public interface AsyncCallBack{

        void onSuccess(String result);

        void onError(int code);
    }

}
