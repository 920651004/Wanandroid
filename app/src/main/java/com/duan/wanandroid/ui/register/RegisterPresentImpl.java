package com.duan.wanandroid.ui.register;

import android.content.Context;
import android.os.Bundle;

import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;

/**
 * Created by Duan on 2019/10/23
 */
public class RegisterPresentImpl extends BaseMvpPresenterImpl<RegisterView> implements RegisterPresent {

    public RegisterPresentImpl(Context context, RegisterView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void Register(String name, String passward, String repassword) {

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
}
