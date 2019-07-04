package com.duan.wanandroid.ui.fragment.knofra;

import android.app.Activity;
import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseContract;
import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.bean.KnowBean;
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

public class KnowfraPresent extends BasePresenter<KnowView.View>implements KnowView.Present{
    Context context;
    List<KnowBean.DataBean> list;
    public KnowfraPresent(Context mcontext) {
        this.context=mcontext;
        getrecycle();
    }


    @Override
    public void getrecycle() {
        OkGo.<String>get(Contents.Main_Know)
                .execute(new StringDialogCallback((Activity) context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        KnowBean bean= JsonUtil.fromJson(response.body().toString(),KnowBean.class);
                        list=new ArrayList<KnowBean.DataBean>();
                        if (bean.getData()==null){
                            ToastUtils.showShort("获取数据为空");
                            return;
                        }
                        list.addAll(bean.getData());
                        mView.setrecycledata(list);

                    }
                });
    }
}
