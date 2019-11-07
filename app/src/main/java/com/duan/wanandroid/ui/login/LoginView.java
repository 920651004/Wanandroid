package com.duan.wanandroid.ui.login;


import com.duan.wanandroid.base.interfaces.BaseMvpView;

/**
 * Created by yanfa-005 on 2018/10/15
 */

public interface LoginView extends BaseMvpView {

    void login(String name, String passward);
    void register();
}
