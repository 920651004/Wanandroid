package com.duan.wanandroid.base;

import android.content.Context;

/**

*/

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;

    protected Context context;
    @Override
    public void attachView(T view) {
        this.mView = view;
        this.context=context;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}