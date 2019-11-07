package com.duan.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;
import com.duan.wanandroid.base.network.factory.RetrofitFactory;

import io.reactivex.disposables.Disposable;

/**
 * Created by Duan on 2019/10/14.
 *
 * Mvp架构的Activity基类
 */

public abstract class BaseMvpActivity<T extends BaseMvpPresenter> extends BaseAppCompatActivity{

    protected T presenter;
    protected Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = initPresenter();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        presenter.init();
        super.init();
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        presenter.process(savedInstanceState);
        super.process(savedInstanceState);
    }

    @Override
    protected void onResume() {
        presenter.resume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        dialog = null;
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        if (dialog == null || !dialog.isShowing()) {
            dialog = new BaseLoadingDialog(this);
            dialog.show();
        }
    }

    @Override
    public void showLoading(String msg) {
        if (dialog == null || !dialog.isShowing()) {
            dialog = new BaseLoadingDialog(this, msg);
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    protected abstract T initPresenter();
}
