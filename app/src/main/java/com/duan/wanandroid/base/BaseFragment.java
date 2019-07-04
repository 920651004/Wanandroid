package com.duan.wanandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import me.yokeyword.fragmentation.SupportFragment;

/**
 * MVP模式的Base fragment
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends SupportFragment
        implements BaseContract.BaseView {


    protected T mPresenter;



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroyView();
    }



}
