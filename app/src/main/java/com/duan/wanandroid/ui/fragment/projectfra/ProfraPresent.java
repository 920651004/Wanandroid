package com.duan.wanandroid.ui.fragment.projectfra;

import android.app.Activity;
import android.content.Context;

import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.bean.Probean;
import com.duan.wanandroid.ui.fragment.mainfra.MainfraView;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.StringDialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class ProfraPresent extends BasePresenter<ProView.View> implements ProView.Present {
    Context context;
    public ProfraPresent(Context mcontext) {
        this.context=mcontext;
    }
    public  void init(){
        getdata();
    }
    @Override
    public void getdata() {
        OkGo.<String>get(Contents.Main_Pro).execute(new StringDialogCallback((Activity) context) {
            @Override
            public void onSuccess(Response<String> response) {
                Probean probean= JsonUtil.fromJson(response.body().toString(),Probean.class);
                List<String> list=new ArrayList<String>();
                for (Probean.DataBean dataBean : probean.getData()) {
                    list.add(dataBean.getName());
                }
                mView.settabdata(list,probean.getData());
                mView.setlistdata(probean.getData());
            }
        });
    }
}
