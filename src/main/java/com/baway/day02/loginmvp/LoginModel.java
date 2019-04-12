package com.baway.day02.loginmvp;

import android.os.AsyncTask;

import com.baway.day02.net.AnsyncHttpClient;

public class LoginModel implements ILoginModel{
    @Override
    public void login(final CallBack callBack) {
        //网络请求
        AnsyncHttpClient.getInstance().getDataAsync("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10", new AnsyncHttpClient.AsyncCallBack() {
            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }

            @Override
            public void onError(int code) {

            }
        });
    }
}
