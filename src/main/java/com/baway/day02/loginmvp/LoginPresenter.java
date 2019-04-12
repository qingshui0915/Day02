package com.baway.day02.loginmvp;

public class LoginPresenter implements ILoginPresenter{

    private LoginModel loginModel;
    private ILoginView view;

    @Override
    public void getModel() {

    }

    @Override
    public void attch(final ILoginView view) {
        loginModel = new LoginModel();
        this.view=view;

        loginModel.login(new ILoginModel.CallBack() {
            @Override
            public void onSuccess(String names) {
                view.getPresenter(names);
            }

            @Override
            public void onFail() {

            }
        });

    }

    @Override
    public void detch() {

        if (view!=null){
            view=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }

        System.gc();

    }
}
