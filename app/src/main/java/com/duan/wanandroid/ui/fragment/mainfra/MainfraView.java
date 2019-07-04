package com.duan.wanandroid.ui.fragment.mainfra;

import com.duan.wanandroid.base.BaseContract;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/10/30
 */

public interface MainfraView {
    interface mview extends BaseContract.BaseView {
        void Bannerdata(List list);
        void  Recydata(List list);
        void  loadmore(List list);
    }
interface Present extends BaseContract.BasePresenter<MainfraView.mview>{
    void getBannerdata();
    void getRecycledata();
}
}
