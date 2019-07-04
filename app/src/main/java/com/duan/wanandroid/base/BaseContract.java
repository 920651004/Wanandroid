package com.duan.wanandroid.base;


import android.content.Context;

/**

 */
public interface BaseContract {

    interface BasePresenter<T extends BaseView> {

        void attachView(T view);

        void detachView();

    }

    interface BaseView {
    }
}
