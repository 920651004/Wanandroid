package com.duan.wanandroid.ui.fragment.mainfra;


import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.base.interfaces.BaseView;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;

import java.util.List;

/**
 * Created by Duan on 2018/10/30
 */

public interface MainfraView  extends BaseMvpView{
    void Bannerdata(List list, List<Mainfrabean.DataBean> mlist);

    void Recydata(List<MainRecycleBean.DataBean.DatasBean> list);

    void loadmore(List list);
}
