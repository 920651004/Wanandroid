package com.duan.wanandroid.ui.register;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;

/**
 * Created by Duan on 2019/10/23
 */
public interface RegisterPresent extends BaseMvpPresenter {
    void Register(String name, String passward, String repassword);
}
