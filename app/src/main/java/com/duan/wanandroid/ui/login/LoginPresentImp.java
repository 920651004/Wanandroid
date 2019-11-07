package com.duan.wanandroid.ui.login;

import android.content.Context;
import android.os.Bundle;

import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;

/**
 * Created by Duan on 2019/10/23
 */
public class LoginPresentImp extends BaseMvpPresenterImpl<LoginView> implements LoginPresent {
    public LoginPresentImp(Context context, LoginView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void process(Bundle savedInstanceState) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void login(String name, String pwd) {

    }
}
