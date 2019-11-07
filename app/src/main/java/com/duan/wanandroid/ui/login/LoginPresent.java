package com.duan.wanandroid.ui.login;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;

/**
 * Created by Duan on 2019/10/23
 */
public interface LoginPresent extends BaseMvpPresenter {
    void login(String name,String pwd);
}
