package com.duan.wanandroid.ui.fragment.navfra;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.NavAdapter;
import com.duan.wanandroid.adapter.NavChildAdapter;
import com.duan.wanandroid.base.BaseFragment;
import com.duan.wanandroid.bean.NavBean;
import com.duan.wanandroid.utlis.CenterLayoutManager;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Navframent extends BaseFragment<NavfraPresent> implements NavView.View {


    Unbinder unbinder;
    NavfraPresent present;
    Context context;
    @BindView(R.id.nav_recycle)
    RecyclerView navRecycle;
    @BindView(R.id.nav_childrecy)
    RecyclerView navChildrecy;
    NavAdapter adapter;
    NavChildAdapter childAdapter;
    List<NavBean.DataBean> nlist;
    private int childCount = 0;
    private int middlechild = 0;
    public static Navframent getIntentce() {
        return new Navframent();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_nav, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }

    private void initview() {
        present = new NavfraPresent(getActivity());
        present.attachView(this);
        present.getrecycle();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        present.detachView();
        unbinder.unbind();
    }


    @Override
    public void setdata(List list) {
        adapter=new NavAdapter(R.layout.item_nav,list);
         nlist=list;
        List<NavBean.DataBean> mlist=new ArrayList<>();
        mlist.add(nlist.get(0));
        childAdapter=new NavChildAdapter(R.layout.item_navchild,mlist);
        LinearLayoutManager manager1=new LinearLayoutManager(getActivity());
        navRecycle.setLayoutManager(manager1);
       // navChildrecy.addItemDecoration(new SpaceItemDecoration(10));
        navChildrecy.setHasFixedSize(true);
        navChildrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        navRecycle.setAdapter(adapter);
        navChildrecy.setAdapter(childAdapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                childCount=manager1.getChildCount();//获取屏幕可见item个数
                if (childCount!=nlist.size()){
                    middlechild=childCount/2;
                }
                if (position <= (manager1.findFirstVisibleItemPosition() + middlechild) && position != 2) {
                    navRecycle.smoothScrollToPosition(position + 1 - middlechild);
                } else {
                    navRecycle.smoothScrollToPosition(position - 1 + middlechild);
                }
                for (NavBean.DataBean bean : nlist) {
                    bean.setCheck(false);
                }
                nlist.get(position).setCheck(true);
                adapter.notifyDataSetChanged();
                List<NavBean.DataBean> mlist=new ArrayList<>();
                mlist.add(nlist.get(position));
                childAdapter.setNewData(mlist);
                childAdapter.notifyDataSetChanged();
            }
        });
    }
}
