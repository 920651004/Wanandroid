package com.duan.wanandroid.ui.login;


import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.LoginInfo;

/**
 * Created by yanfa-005 on 2018/10/15
 */

public interface LoginView extends BaseMvpView {

    void getLoginInfo(LoginInfo info);
}
