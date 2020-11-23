package com.duan.wanandroid.ui.fragment.projectfra;


import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.Probean;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public class Proframent extends BaseMvpFrament<ProPresent> implements ProView {

    @BindView(R.id.pro_slid)
    SlidingTabLayout proSlid;
    @BindView(R.id.pro_vp)
    ViewPager proVp;

    String mTitle[];
    MyPagerAdapter adapter;
    List<Probean.DataBean> mlist;
    Prochildframent prochildframent;
    private ArrayList<Prochildframent> mFragments = new ArrayList<>();

    public static Proframent getIntentce() {
        return new Proframent();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.frament_pro;
    }


    @NonNull
    @Override
    protected ProPresent initPresenter() {
        return new ProPresentImpl(getActivity(), this, this);
    }

    @Override
    public void initView() {
        presenter.getdata();
    }


    @Override
    public void settabdata(List list, List data) {
        prochildframent = new Prochildframent();
        mTitle = new String[list.size()];
        list.toArray(mTitle);
        mlist = new ArrayList<>();
        mlist = data;
        for (Probean.DataBean bean : mlist) {
            mFragments.add(Prochildframent.getIntentce(bean.getId()));
        }
        adapter = new MyPagerAdapter(getFragmentManager());
        proVp.setAdapter(adapter);
        proSlid.setViewPager(proVp);


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
