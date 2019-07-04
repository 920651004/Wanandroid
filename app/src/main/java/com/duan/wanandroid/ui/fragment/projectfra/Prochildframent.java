package com.duan.wanandroid.ui.fragment.projectfra;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.duan.wanandroid.R;
import com.duan.wanandroid.adapter.ProchilAdapter;
import com.duan.wanandroid.base.BaseFragment;
import com.duan.wanandroid.bean.MessageEvnet;
import com.duan.wanandroid.bean.ProchildBean;
import com.duan.wanandroid.ui.web.WebDetialActivity;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.StringDialogCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

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

public class Prochildframent extends BaseFragment<ProChildPresent> implements ProChildView.View {

    private  int mid;
    Unbinder unbinder;
    ProChildPresent present;
    Context context;
    @BindView(R.id.pro_recycle)
    RecyclerView proRecycle;
    ProchilAdapter adapter;
    List<ProchildBean.DataBean.DatasBean> mlist;
    public static Prochildframent getIntentce(int id) {
        Prochildframent prochildframent=new Prochildframent();
        Bundle bundle=new Bundle();
        bundle.putInt("mid",id);
        prochildframent.setArguments(bundle);
       // mid=id;
        return prochildframent;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_prochild, container, false);
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initview();
    }


    private void initview() {
        Bundle bundle=getArguments();
        mid=bundle.getInt("mid");
      //  present = new ProChildPresent(getActivity());
       // present.attachView(this);
       getdatabyid(mid);


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(MessageEvnet messageEvnet) {
        if (mlist!=null&&adapter!=null){
            mlist.clear();
            adapter.notifyDataSetChanged();
        }
        getdatabyid(messageEvnet.getPosition());
        LogUtils.e(messageEvnet.getPosition());

    }
    int page=0;
     public void  getdatabyid( int id){
        OkGo.<String>get(String.format(Contents.Main_Pro_artice,page))
                .params("cid",id)
                .execute(new StringDialogCallback((Activity) context) {
                    @Override
                    public void onSuccess(Response<String> response) {
                        mlist=new ArrayList<>();
                        ProchildBean bean= JsonUtil.fromJson(response.body(),ProchildBean.class);
                        mlist=bean.getData().getDatas();
                        adapter=new ProchilAdapter(R.layout.item_profra,mlist);
                        if (proRecycle!=null){
                            proRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                            proRecycle.setAdapter(adapter);
                        }
                        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(_mActivity, view, getString(R.string.tranname));
                                Intent intent=new Intent(_mActivity, WebDetialActivity.class);
                                intent.putExtra("title",mlist.get(position).getTitle());
                                intent.putExtra("url",mlist.get(position).getLink());
                                startActivity(intent,options.toBundle());
                            }
                        });

                    }
                });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
    @Override
    public void getdata(List list) {
        LogUtils.e(JsonUtil.toJson(list));

    }
}
