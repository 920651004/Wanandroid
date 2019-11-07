package com.duan.wanandroid.ui.fragment.navfra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.NavAdapter;
import com.duan.wanandroid.adapter.NavChildAdapter;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.NavBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Navframent extends BaseMvpFrament<NavPrensent> implements NavView {


    NavAdapter adapter;
    NavChildAdapter childAdapter;
    List<NavBean.DataBean> nlist;
    @BindView(R.id.nav_recycle)
    RecyclerView navRecycle;
    @BindView(R.id.nav_childrecy)
    RecyclerView navChildrecy;
    @BindView(R.id.mian_layout)
    LinearLayout mianLayout;
    Unbinder unbinder;
    private int childCount = 0;
    private int middlechild = 0;

    public static Navframent getIntentce() {
        return new Navframent();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.frament_nav;
    }


    @Override
    public void setdata(List list) {
        adapter = new NavAdapter(R.layout.item_nav, list);
        nlist = list;
        List<NavBean.DataBean> mlist = new ArrayList<>();
        mlist.add((NavBean.DataBean) list.get(0));
        childAdapter = new NavChildAdapter(R.layout.item_navchild, mlist);
        LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        navRecycle.setLayoutManager(manager1);
        navChildrecy.setHasFixedSize(true);
        navChildrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        navRecycle.setAdapter(adapter);
        navChildrecy.setAdapter(childAdapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                childCount = manager1.getChildCount();//获取屏幕可见item个数
                if (childCount != nlist.size()) {
                    middlechild = childCount / 2;
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
                List<NavBean.DataBean> mlist = new ArrayList<>();
                mlist.add(nlist.get(position));
                childAdapter.setNewData(mlist);
                childAdapter.notifyDataSetChanged();
            }
        });
    }


    @NonNull
    @Override
    protected NavPrensent initPresenter() {
        return new NavPresentImpl(getActivity(), this, this);
    }

    @Override
    public void process(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

        presenter.getrecycle();
    }

}
