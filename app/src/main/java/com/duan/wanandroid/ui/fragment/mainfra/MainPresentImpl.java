package com.duan.wanandroid.ui.fragment.mainfra;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2019/10/23
 */
public class MainPresentImpl extends BaseMvpPresenterImpl<MainfraView> implements MainPresent {

    private int page = 0;

    public MainPresentImpl(Context context, MainfraView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getdata() {

        Mainfrabean.getBanInfo(new CommJsonObserver<Mainfrabean>(getLifeFul()) {
            @Override
            public void onSuccess(Mainfrabean mainfrabean) {
                getView().hideLoading();
                if (mainfrabean.getData() != null) {
                    List<String> mlist = new ArrayList<>();
                    for (Mainfrabean.DataBean bean : mainfrabean.getData()) {
                        mlist.add(bean.getImagePath());
                    }
                    getView().Bannerdata(mlist,mainfrabean.getData());
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
    public void getrecycle() {
        getView().showLoading();
        MainRecycleBean.getRvInfo(new CommJsonObserver<MainRecycleBean>(getLifeFul()) {
            @Override
            public void onSuccess(MainRecycleBean mainRecycleBean) {
                getView().hideLoading();
                if (mainRecycleBean.getData() != null) {
                    getView().Recydata(mainRecycleBean.getData().getDatas());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                ToastUtils.showShort(message);
            }
        }, page);
    }

    @Override
    public void loadmore(RefreshLayout refreshLayout) {
        getView().showLoading();
        MainRecycleBean.getRvInfo(new CommJsonObserver<MainRecycleBean>(getLifeFul()) {
            @Override
            public void onSuccess(MainRecycleBean mainRecycleBean) {
                getView().hideLoading();
                refreshLayout.finishLoadMore();
                if (mainRecycleBean.getData() != null) {
                    getView().Recydata(mainRecycleBean.getData().getDatas());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                refreshLayout.finishLoadMore();
                ToastUtils.showShort(message);
            }
        }, page);
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
