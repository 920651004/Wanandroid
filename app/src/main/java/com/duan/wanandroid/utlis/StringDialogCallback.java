package com.duan.wanandroid.utlis;

import android.app.Activity;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

/**
 * Created by yanfa-005 on 2019/4/17
 */
public class StringDialogCallback extends StringCallback {
    Activity mActivity;
    public StringDialogCallback(Activity activity) {
        mActivity=activity;
    }

    @Override
    public void onStart(Request<String, ? extends Request> request) {
        super.onStart(request);
        ProgressDialogUtil.showLoading(mActivity);
    }


    @Override
    public void onSuccess(Response<String> response) {
    }

    @Override
    public void onFinish() {
        super.onFinish();
        ProgressDialogUtil.dismissAll();
    }
}
