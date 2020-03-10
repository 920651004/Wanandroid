package com.duan.wanandroid.ui.fragment.wx;

import android.os.Bundle;

import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.WxChildadapter;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.WxArticleByOrder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;


public class WXChildFragment extends BaseMvpFrament<WxChildPresent> implements WxchildView {

    @BindView(R.id.wx_child_rv)
    RecyclerView wxChildRv;
    @BindView(R.id.wx_chidl_sf)
    SmartRefreshLayout wxChidlSf;
    Unbinder unbinder;
    private int mid;

    private WxChildadapter wxChildadapter;

    public static WXChildFragment getIntentce(int id) {
        WXChildFragment wxChildFragment = new WXChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mid", id);
        wxChildFragment.setArguments(bundle);
        // mid=id;
        return wxChildFragment;
    }

    @NonNull
    @Override
    protected WxChildPresent initPresenter() {
        return new WxChildImpl(getActivity(), this, this);
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        mid = bundle.getInt("mid");
        presenter.getListData(mid);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wxchild;
    }

    @Override
    public void setListData(List<WxArticleByOrder.DataBean.DatasBean> list) {
        wxChildadapter = new WxChildadapter(R.layout.item_mianfra, list);
        wxChildRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        wxChildRv.setAdapter(wxChildadapter);
        wxChildadapter.setOnItemChildClickListener((adapter, view, position) -> {

        });
    }
}
