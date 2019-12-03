package com.duan.wanandroid.ui.fragment.wx;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseMvpFrament;
import com.duan.wanandroid.bean.WxArticle;
import com.duan.wanandroid.ui.fragment.projectfra.Prochildframent;
import com.duan.wanandroid.ui.fragment.projectfra.Proframent;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class WxActicleFragment extends BaseMvpFrament<WxActiclePresent> implements WxArticleView {

    @BindView(R.id.wx_tab)
    SlidingTabLayout wxTab;
    @BindView(R.id.wx_vp)
    ViewPager wxVp;
    String mTitle[];
    private ArrayList<WXChildFragment> mFragments = new ArrayList<>();
    private MyPagerAdapter adapter;
    private WXChildFragment fragment;

    public static WxActicleFragment getIntentce() {
        return new WxActicleFragment();
    }

    @NonNull
    @Override
    protected WxActiclePresent initPresenter() {
        return new WxArticleImpl(getActivity(), this, this);
    }

    @Override
    public void initView() {
        adapter = new MyPagerAdapter(getChildFragmentManager());
        presenter.getTabLayoutData();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wx_acticle;
    }

    @Override
    public void setTablayoutData(List<WxArticle.DataBean> list,List<String> mlist) {
        mTitle=new String[mlist.size()];
        mlist.toArray(mTitle);
        for (WxArticle.DataBean bean : list) {
            mFragments.add(WXChildFragment.getIntentce(bean.getId()));
        }
        wxVp.setAdapter(adapter);
        wxTab.setViewPager(wxVp,mTitle);
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