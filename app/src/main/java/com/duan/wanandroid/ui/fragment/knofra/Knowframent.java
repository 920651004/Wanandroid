package com.duan.wanandroid.ui.fragment.knofra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.KnowAdapter;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.KnowBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Knowframent extends BaseMvpFrament<KnoPresent> implements KnowView {


    Unbinder unbinder;
    @BindView(R.id.main_fra_recycle)
    RecyclerView mainFraRecycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.mian_layout)
    RelativeLayout mianLayout;
    KnowAdapter adapter;

    public static Knowframent getIntentce() {
        return new Knowframent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frament_kno;
    }

    @NonNull
    @Override
    protected KnoPresent initPresenter() {
        return new KnoPresentImpl(getActivity(), this, this);
    }

    @Override
    public void initView() {
        presenter.getrecycle();
    }


    @Override
    public void setrecycledata(List list) {
        adapter = new KnowAdapter(R.layout.item_knofra, list);
        mainFraRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainFraRecycle.setAdapter(adapter);

    }

}
