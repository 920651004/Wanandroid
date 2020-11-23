package com.duan.wanandroid.ui.fragment.wx;

import android.content.Context;
import android.os.Bundle;

import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.WxArticleByOrder;

/**
 * Created by Duan on 2019/11/5
 */
public class WxChildImpl extends BaseMvpPresenterImpl<WxchildView> implements WxChildPresent {
    private int page = 1;

    WxChildImpl(Context context, WxchildView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getListData(int id) {
        getView().showLoading();
        WxArticleByOrder.WxOrder(page, id, new CommJsonObserver<WxArticleByOrder>(getLifeFul()) {
            @Override
            public void onSuccess(WxArticleByOrder wxArticleByOrder) {
                getView().hideLoading();
                if (wxArticleByOrder.getErrorCode() == 0) {
                    getView().setListData(wxArticleByOrder.getData().getDatas());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
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
