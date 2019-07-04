package com.duan.wanandroid.ui.register;

import android.content.Context;

import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.utlis.Contents;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * Created by yanfa-005 on 2018/10/16
 */

public class RegisterPresenter  extends BasePresenter<RegisterView.review>{
    Context context;

    public RegisterPresenter(Context context) {
        this.context = context;
    }
    void Register(String name, String passward,String repassword){
        OkGo.<String>post(Contents.Register)
                .params("username",name)
                .params("password",passward)
                .params("repassword",repassword)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }
}
