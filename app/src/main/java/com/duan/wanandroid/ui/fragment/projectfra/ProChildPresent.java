package com.duan.wanandroid.ui.fragment.projectfra;

import android.app.Activity;
import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.BaseContract;
import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.bean.ProchildBean;
import com.duan.wanandroid.ui.fragment.projectfra.ProChildView.Present;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.StringDialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/21
 */

public class ProChildPresent extends BasePresenter<ProChildView.View> implements ProChildView.Present {

    int page=1;
    public ProChildPresent(Context context) {
        this.context=context;
    }


    @Override
    public void setdata(int id) {
        OkGo.<String>get(String.format(Contents.Main_Pro_artice,page))
                .params("cid",id)
                .execute(new StringDialogCallback((Activity) context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        ProchildBean bean= JsonUtil.fromJson(response.body(),ProchildBean.class);
                        LogUtils.e("sss");
                        mView.getdata(bean.getData().getDatas());
                    }
                });
    }
}
