package com.duan.wanandroid.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import java.io.Serializable;


import me.yokeyword.fragmentation.SupportActivity;

/**
 *
 *
 * @description: 通用基类
 */

/**

 */
public abstract class BaseActivity<T1 extends BaseContract.BasePresenter> extends SupportActivity implements BaseContract.BaseView {

    protected InputMethodManager inputMethodManager;

    private boolean isEventBusEnabled = false;
    protected T1 mPresenter;
    protected Context mContext;
    protected View mView;
    protected Activity activity;
    private ViewGroup mNormalView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        activity = this;
        inputMethodManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        init();
    }

    protected void init() {
        attachView();

    }

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
       inputMethodManager=null;
    }



    protected void hideSoftKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null && inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    public String getStringExtra(String key) {
        return getIntent().getStringExtra(key);
    }

    public Serializable getObjectExtra(String key) {
        return getIntent().getSerializableExtra(key);
    }

    private void setAppTheme() {
        /*switch (BuildConfig.THEME) {
            case 1:
                setTheme(R.style.theme_1);
                break;
            case 2:
                setTheme(R.style.theme_2);
                break;
            default:
                break;
        }*/
    }
}
