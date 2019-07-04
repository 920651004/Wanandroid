package com.duan.wanandroid.ui.fragment.projectfra;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseFragment;
import com.duan.wanandroid.bean.MessageEvnet;
import com.duan.wanandroid.bean.Probean;
import com.duan.wanandroid.bean.ProchildBean;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JsonUtil;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Proframent extends BaseFragment<ProfraPresent> implements ProView.View {

    Unbinder unbinder;
    ProfraPresent present;
    Context context;
    @BindView(R.id.pro_slid)
    SlidingTabLayout proSlid;
    @BindView(R.id.pro_vp)
    ViewPager proVp;

    String mTitle[];
    MyPagerAdapter adapter;
    ProChildPresent child;
    List<Probean.DataBean> mlist;
    Prochildframent prochildframent;
    private ArrayList<Prochildframent> mFragments = new ArrayList<>();

    public static Proframent getIntentce() {
        return new Proframent();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_pro, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }


    private void initview() {
        prochildframent=new Prochildframent();

        present = new ProfraPresent(getActivity());
        present.attachView(this);
        present.init();

        proSlid.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                LogUtils.e(mlist.get(position).getId());
               // EventBus.getDefault().post(new MessageEvnet(mlist.get(position).getId()));

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        proVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.e(mlist.get(position).getId());
              // EventBus.getDefault().post(new MessageEvnet(mlist.get(position).getId()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @Override
    public void settabdata(List list,List data) {
        mTitle=new String[list.size()];
        list.toArray(mTitle);
       mlist=new ArrayList<>();
        mlist=data;

        for (Probean.DataBean bean : mlist) {
           // EventBus.getDefault().post(new MessageEvnet(bean.getId()));
            mFragments.add(Prochildframent.getIntentce(bean.getId()));

        }
        /*for (String s : mTitle) {
            mFragments.add(Prochildframent.getIntentce(mlist.get(0).getId()));
            EventBus.getDefault().post(new MessageEvnet(mlist.get(position).getId()));
        }*/
        adapter=new MyPagerAdapter(getFragmentManager());
        proVp.setAdapter(adapter);
        proVp.setOffscreenPageLimit(1);
        proSlid.setViewPager(proVp);



    }


    @Override
    public void setlistdata(List list) {
        mlist=list;

    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
