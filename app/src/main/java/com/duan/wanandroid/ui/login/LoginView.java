package com.duan.wanandroid.ui.login;


import com.duan.wanandroid.base.BaseContract;

/**
 * Created by yanfa-005 on 2018/10/15
 */

public interface LoginView  {
    public  interface mview extends BaseContract.BaseView {

    }
    void login(String name, String passward);
    void register();
}
