package com.duan.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

/**
 * Created by Duan on 2019/10/23
 */
public abstract class BaseMvcFrament extends BaseFrament {
    protected Dialog dialog;

    @Override
    public void showLoading() {
        if (dialog == null || !dialog.isShowing()) {
            dialog = new BaseLoadingDialog(mActivity);
            dialog.show();
        }
    }

    @Override
    public void showLoading(String msg) {
        if (dialog == null || !dialog.isShowing()) {
            dialog = new BaseLoadingDialog(mActivity, msg);
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
        super.showMsg(msg);
        ToastUtils.showShort(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
            dialog=null;
        }
    }


    @Override
    protected void init() {
        initView();
        super.init();
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        super.process(savedInstanceState);
    }
    public abstract void initView();
}
