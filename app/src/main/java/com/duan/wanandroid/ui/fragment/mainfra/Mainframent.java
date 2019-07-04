package com.duan.wanandroid.ui.fragment.mainfra;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.Mainadapter;
import com.duan.wanandroid.base.BaseFragment;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;
import com.duan.wanandroid.ui.DragActivity;
import com.duan.wanandroid.ui.web.WebDetialActivity;
import com.duan.wanandroid.utlis.GlideImageLoader;
import com.duan.wanandroid.utlis.JsonUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Mainframent extends BaseFragment<MainfraPresent> implements MainfraView.mview, OnBannerListener {

    @BindView(R.id.main_fra_branner)
    Banner mainFraBranner;
    @BindView(R.id.main_fra_recycle)
    RecyclerView mainFraRecycle;
    Unbinder unbinder;
    MainfraPresent present;
    Context context;
    Mainadapter mainadapter;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    List<MainRecycleBean.DataBean.DatasBean> mlist=new ArrayList<>();
    public static Mainframent getIntentce() {
        return new Mainframent();
    }

    List<Mainfrabean.DataBean> nlist ;
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.frament_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }

    private void initview() {
        present = new MainfraPresent(getActivity());
        present.attachView(this);
        present.init();
        refresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                present.loadmore(refreshLayout);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void Bannerdata(List list) {
        List<String> mlist = new ArrayList<>();
        nlist = list;
        for (Mainfrabean.DataBean bean : nlist) {
            mlist.add(bean.getImagePath());
        }

        mainFraBranner.setImages(mlist)
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void Recydata(List list) {

       mlist=list;
        mainadapter =new Mainadapter(R.layout.item_mianfra,list);
        mainFraRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainFraRecycle.setAdapter(mainadapter);
        mainadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(_mActivity, view, getString(R.string.tranname));
                Intent intent=new Intent(_mActivity, DragActivity.class);
                intent.putExtra("title",mlist.get(position).getTitle());
                intent.putExtra("url",mlist.get(position).getLink());
                startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public void loadmore(List list) {
      mainadapter.setNewData(list);
        mainadapter.notifyDataSetChanged();
    }


    @Override
    public void OnBannerClick(int position) {
        Intent intent=new Intent(_mActivity, WebDetialActivity.class);
        intent.putExtra("title",nlist.get(position).getTitle());
        intent.putExtra("url",nlist.get(position).getUrl());
        startActivity(intent);
    }
}
