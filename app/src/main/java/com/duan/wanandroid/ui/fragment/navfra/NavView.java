package com.duan.wanandroid.ui.fragment.navfra;

import com.duan.wanandroid.base.BaseContract;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/16
 */

public class NavView   {
    interface View extends BaseContract.BaseView{
        void setdata(List list);
    }
    interface Present extends BaseContract.BasePresenter<NavView.View>{
        void getrecycle();
    }
}
