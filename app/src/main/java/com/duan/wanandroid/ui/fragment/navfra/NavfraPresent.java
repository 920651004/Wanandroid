package com.duan.wanandroid.ui.fragment.navfra;

import android.app.Activity;
import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.bean.NavBean;
import com.duan.wanandroid.ui.fragment.mainfra.MainfraView;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.StringDialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class NavfraPresent extends BasePresenter<NavView.View> implements NavView.Present{
    Context context;
    public NavfraPresent(Context mcontext) {
        this.context=mcontext;
    }


    @Override
    public void getrecycle() {
        OkGo.<String>get(Contents.Main_Nav)
                .execute(new StringDialogCallback((Activity) context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        NavBean bean= JsonUtil.fromJson(response.body().toString(),NavBean.class);
                        if (bean.getData()==null){
                            return;
                        }
                        mView.setdata(bean.getData());
                    }
                });
    }
}
