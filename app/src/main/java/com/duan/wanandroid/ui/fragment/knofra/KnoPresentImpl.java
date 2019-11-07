package com.duan.wanandroid.ui.fragment.knofra;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.KnowBean;

/**
 * Created by Duan on 2019/10/23
 */
public class KnoPresentImpl extends BaseMvpPresenterImpl<KnowView> implements KnoPresent {

    public KnoPresentImpl(Context context, KnowView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getrecycle() {
        getView().showLoading();
        KnowBean.GetRvInfo(new CommJsonObserver<KnowBean>(getLifeFul()) {
            @Override
            public void onSuccess(KnowBean knowBean) {
                getView().hideLoading();
                if (knowBean.getData() == null) {
                    ToastUtils.showShort("获取数据为空");
                    return;
                }
                getView().setrecycledata(knowBean.getData());
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
