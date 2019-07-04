package com.duan.wanandroid.ui.login;

import android.content.Context;

import com.duan.wanandroid.base.BasePresenter;

/**
 * Created by yanfa-005 on 2018/10/15
 */

public class LoginPresenter extends BasePresenter<LoginView.mview> implements LoginView{
    Context context;
    String Password;
    String Name;
    public LoginPresenter(Context context) {
        this.context=context;
        /*this.Password=Paw;
        this.Name=name;*/

    }


    @Override
    public void login(String name, String passward) {

    }

    @Override
    public void attachView(mview view) {
        super.attachView(view);

    }

    @Override
    public void register() {

    }


}
