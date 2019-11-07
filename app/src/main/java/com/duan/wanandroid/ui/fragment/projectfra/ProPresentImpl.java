package com.duan.wanandroid.ui.fragment.projectfra;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.Probean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2019/10/23
 */
public class ProPresentImpl extends BaseMvpPresenterImpl<ProView> implements ProPresent {

    public ProPresentImpl(Context context, ProView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getdata() {
       getView().showLoading();
        Probean.getProInfo(new CommJsonObserver<Probean>(getLifeFul()) {
            @Override
            public void onSuccess(Probean probean) {
                getView().hideLoading();
                 if (probean.getData()!=null){
                     List<String> list=new ArrayList<>();
                     for (Probean.DataBean dataBean : probean.getData()) {
                         list.add(dataBean.getName());
                     }
                     getView().settabdata(list,probean.getData());
                 }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
            }

            @Override
            public void onComplete() {
                super.onComplete();
                getView().hideLoading();
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
