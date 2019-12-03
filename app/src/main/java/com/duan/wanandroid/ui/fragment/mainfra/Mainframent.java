package com.duan.wanandroid.ui.fragment.mainfra;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.Mainadapter;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;
import com.duan.wanandroid.ui.search.SearchMvpActivity;
import com.duan.wanandroid.ui.web.WebDetialActivity;
import com.duan.wanandroid.utlis.GlideImageLoader;
import com.duan.wanandroid.utlis.JumpUtlis;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

public class Mainframent extends BaseMvpFrament<MainPresent> implements MainfraView, OnBannerListener {


    Mainadapter mainadapter;

    List<MainRecycleBean.DataBean.DatasBean> mlist = new ArrayList<>();


    @BindView(R.id.main_fra_branner)
    Banner mainFraBranner;
    @BindView(R.id.main_fra_recycle)
    RecyclerView mainFraRecycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.mian_layout)
    RelativeLayout mianLayout;

    public static Mainframent getIntentce() {
        return new Mainframent();
    }

    List<Mainfrabean.DataBean> nlist;


    @Override
    protected int getLayoutId() {
        return R.layout.frament_main;
    }

    @NonNull
    @Override
    protected MainPresent initPresenter() {
        return new MainPresentImpl(getActivity(), this, this);
    }

    @Override
    public void initView() {

        presenter.getdata();
        presenter.getrecycle();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void Bannerdata(List list,List<Mainfrabean.DataBean> mlist) {
        nlist=new ArrayList<>();
        nlist.addAll(mlist);
        if (mainFraBranner!=null){
            mainFraBranner.setImages(list)
                    .setImageLoader(new GlideImageLoader())
                    .setIndicatorGravity(BannerConfig.RIGHT)
                    .setOnBannerListener(this)
                    .start();
        }


    }

    @Override
    public void Recydata(List<MainRecycleBean.DataBean.DatasBean> list) {

        mainadapter = new Mainadapter(R.layout.item_mianfra, list);
        mainFraRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainFraRecycle.setAdapter(mainadapter);
        mainadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(_mActivity, view, getString(R.string.tranname));
                JumpUtlis.ToWebDetial(getActivity(),
                        list.get(position).getLink(),
                        list.get(position).getTitle(),
                        options);
            }
        });
    }

    @Override
    public void loadmore(List list) {
        mainadapter.setNewData(list);
        mainadapter.notifyDataSetChanged();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void OnBannerClick(int position) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(_mActivity, mainFraBranner, getString(R.string.tranname));
        JumpUtlis.ToWebDetial(getActivity(),
                nlist.get(position).getUrl(),
                nlist.get(position).getTitle(),
                options);
    }

}
