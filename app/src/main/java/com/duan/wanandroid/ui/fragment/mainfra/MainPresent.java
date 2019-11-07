package com.duan.wanandroid.ui.fragment.mainfra;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

/**
 * Created by Duan on 2019/10/23
 */
public interface MainPresent extends BaseMvpPresenter {
    void getdata();

    void getrecycle();

    void loadmore(RefreshLayout refreshLayout);
}
