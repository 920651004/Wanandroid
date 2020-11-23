package com.duan.wanandroid.ui.fragment.projectfra;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.ProchildBean;

/**
 * Created by Duan on 2019/10/23
 */
public class ProChildPresentImpl extends BaseMvpPresenterImpl<ProChildView> implements ProChildPresenter {
    private int page = 0;

    public ProChildPresentImpl(Context context, ProChildView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void setdata(int id) {
        getView().showLoading();
        LogUtils.e(getLifeFul().isAlive());
        ProchildBean.getProChildInfo(new CommJsonObserver<ProchildBean>(getLifeFul()) {
            @Override
            public void onSuccess(ProchildBean prochildBean) {
                getView().hideLoading();
                if (prochildBean.getData() != null) {
                    getView().getdata(prochildBean.getData().getDatas());
                }

            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                ToastUtils.showShort(message);
            }
        }, page, id);
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
