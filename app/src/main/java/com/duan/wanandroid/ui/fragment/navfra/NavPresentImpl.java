package com.duan.wanandroid.ui.fragment.navfra;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.NavBean;

/**
 * Created by Duan on 2019/10/23
 */
public class NavPresentImpl extends BaseMvpPresenterImpl<NavView> implements NavPrensent {
    public NavPresentImpl(Context context, NavView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getrecycle() {
        getView().showLoading();
        NavBean.getNavInfo(new CommJsonObserver<NavBean>(getLifeFul()) {
            @Override
            public void onSuccess(NavBean navBean) {
                getView().hideLoading();
                if (navBean.getData() != null) {
                    getView().setdata(navBean.getData());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                ToastUtils.showShort(message);
            }
        });
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
