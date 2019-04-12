package com.baway.day02.loginmvp;

public interface ILoginModel {

    void login(CallBack callBack);
    interface CallBack{
        void onSuccess(String names);

        void onFail();
    }
}
