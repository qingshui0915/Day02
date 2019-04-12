package com.baway.day02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.baway.day02.adapter.HomeAdapter;
import com.baway.day02.bean.HomeBean;
import com.baway.day02.loginmvp.ILoginView;
import com.baway.day02.loginmvp.LoginPresenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ILoginView {


    private LoginPresenter loginPresenter;
    private ListView home_list;
    private List<HomeBean.ResultBean> homeBeanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home_list = findViewById(R.id.home_list);

        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
    }

    @Override
    public void getPresenter(String name) {
        //login_name_et.setText(name);
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(name, HomeBean.class);

        homeBeanResult = homeBean.getResult();
        //适配器
        home_list.setAdapter(new HomeAdapter(this,homeBeanResult));

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
}
