package com.baway.day02.loginmvp;

public interface ILoginPresenter {
    void getModel();

    void attch(ILoginView  view);

    void detch();
}
