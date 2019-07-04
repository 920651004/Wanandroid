package com.duan.wanandroid.ui.fragment.knofra;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.KnowAdapter;
import com.duan.wanandroid.base.BaseFragment;
import com.duan.wanandroid.bean.KnowBean;
import com.duan.wanandroid.utlis.JsonUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Knowframent extends BaseFragment<KnowfraPresent> implements KnowView.View {


    @BindView(R.id.main_fra_recycle)
    RecyclerView mainFraRecycle;
    Unbinder unbinder;
    KnowfraPresent present;
    Context context;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    List<KnowBean.DataBean> mlist;
    KnowAdapter adapter;
    public static Knowframent getIntentce() {
        return new Knowframent();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_kno, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }


    private void initview() {
        present = new KnowfraPresent(getActivity());
        present.attachView(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void setrecycledata(List list) {
        adapter=new KnowAdapter(R.layout.item_knofra,list);
        mainFraRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainFraRecycle.setAdapter(adapter);

    }
}
