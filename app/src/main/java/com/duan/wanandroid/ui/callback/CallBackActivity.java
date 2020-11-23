package com.duan.wanandroid.ui.callback;


import com.blankj.utilcode.util.ResourceUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.CallBackAdapter;
import com.duan.wanandroid.adapter.CallBackChildAdapter;
import com.duan.wanandroid.base.BaseMvcActivity;
import com.duan.wanandroid.bean.Hostinfo;
import com.duan.wanandroid.utlis.CallBack;
import com.duan.wanandroid.utlis.JsonUtil;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class CallBackActivity extends BaseMvcActivity implements CallBack {

    @BindView(R.id.call_back_rv)
    RecyclerView callBackRv;
    CallBackAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_call_back;

    }


    @Override
    public void initView() {
        Hostinfo bean = JsonUtil.fromJson(ResourceUtils.readAssets2String("info.json"), Hostinfo.class);
        adapter = new CallBackAdapter(R.layout.item_call_back, bean.getReportGroupConfig(), this);
        callBackRv.setLayoutManager(new LinearLayoutManager(this));
        callBackRv.setAdapter(adapter);
    }


    @Override
    public void setAdapter(CallBackChildAdapter adapter) {

        adapter.setOnItemChildClickListener((adapter1, view, position) -> {

        });
    }
}
