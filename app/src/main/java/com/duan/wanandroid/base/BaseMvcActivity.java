package com.duan.wanandroid.base;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Duan on 2019/10/14.
 * <p>
 * Mvc架构的Activity基类，用于功能较少时使用
 */

public abstract class BaseMvcActivity extends BaseAppCompatActivity {
    protected Dialog dialog;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dialog = null;
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        super.process(savedInstanceState);
    }

    @Override
    protected void init() {
        initView();
        super.init();
    }

    public abstract void initView();
}
