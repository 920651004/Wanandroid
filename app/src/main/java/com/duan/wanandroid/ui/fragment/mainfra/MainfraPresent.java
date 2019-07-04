package com.duan.wanandroid.ui.fragment.mainfra;

import android.app.Activity;
import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.BaseApplication;
import com.duan.wanandroid.base.BaseContract;
import com.duan.wanandroid.base.BasePresenter;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.ProgressDialogUtil;
import com.duan.wanandroid.utlis.StringDialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class MainfraPresent extends BasePresenter<MainfraView.mview> implements MainfraView.Present {
    Context context;
    int page=0;
    List<Mainfrabean.DataBean> mlist=new ArrayList<>();
    List<MainRecycleBean.DataBean.DatasBean> list=new ArrayList<>();
    public MainfraPresent(Context mcontext) {
        this.context=mcontext;

    }
   public   void  init(){
       getdata();
       getrecycle();
   }

    void  getdata(){
        OkGo.<String>get(Contents.Baner).execute(new StringDialogCallback((Activity) context) {

            @Override
            public void onSuccess(Response<String> response) {
                Mainfrabean mainfrabean= JsonUtil.fromJson(response.body(),Mainfrabean.class);
                if (mainfrabean.getData()!=null){
                    mlist.addAll(mainfrabean.getData());
                        mView.Bannerdata(mlist);
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                ProgressDialogUtil.dismissAll();
            }
        });
    }

    void getrecycle(){
        OkGo.<String>
                get(String.format(Contents.Main_article,page))
        .execute(new StringDialogCallback((Activity) context) {
            @Override
            public void onSuccess(Response<String> response) {
                MainRecycleBean bean=JsonUtil.fromJson(response.body().toString(),MainRecycleBean.class);
                list=new ArrayList<MainRecycleBean.DataBean.DatasBean>();
                list.addAll(bean.getData().getDatas());
                mView.Recydata(list);


            }
        });
    }
    void loadmore(final RefreshLayout refreshLayout){
        ++page;
        OkGo.<String>
                get(String.format(Contents.Main_article,page))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (refreshLayout!=null){
                            refreshLayout.finishLoadMore();
                        }
                        MainRecycleBean bean=JsonUtil.fromJson(response.body().toString(),MainRecycleBean.class);
                        if (bean.getData().getDatas()!=null){
                            list.addAll(bean.getData().getDatas());
                            mView.loadmore(list);
                        }
                    }
                });
    }


    @Override
    public void getBannerdata() {

    }

    @Override
    public void getRecycledata() {

    }
}
