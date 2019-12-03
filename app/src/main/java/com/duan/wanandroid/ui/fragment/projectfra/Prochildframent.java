package com.duan.wanandroid.ui.fragment.projectfra;

import android.app.Activity;
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

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.ProchilAdapter;

import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.MessageEvnet;
import com.duan.wanandroid.bean.ProchildBean;
import com.duan.wanandroid.ui.web.WebDetialActivity;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.JumpUtlis;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Prochildframent extends BaseMvpFrament<ProChildPresenter> implements ProChildView {

    private int mid;

    Context context;
    @BindView(R.id.pro_recycle)
    RecyclerView proRecycle;
    ProchilAdapter adapter;
    List<ProchildBean.DataBean.DatasBean> mlist;

    public static Prochildframent getIntentce(int id) {
        Prochildframent prochildframent = new Prochildframent();
        Bundle bundle = new Bundle();
        bundle.putInt("mid", id);
        prochildframent.setArguments(bundle);
        // mid=id;
        return prochildframent;
    }




    @Override
    protected int getLayoutId() {
        return R.layout.frament_prochild;
    }


    @NonNull
    @Override
    protected ProChildPresenter initPresenter() {
        return new ProChildPresentImpl(_mActivity, this, this);
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        mid = bundle.getInt("mid");
        presenter.setdata(mid);
    }

    @Override
    public void getdata(List<ProchildBean.DataBean.DatasBean> list) {
        adapter = new ProchilAdapter(R.layout.item_profra, list);
        proRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        proRecycle.setAdapter(adapter);

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
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
}
