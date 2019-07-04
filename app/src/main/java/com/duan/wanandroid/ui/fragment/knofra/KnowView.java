package com.duan.wanandroid.ui.fragment.knofra;

import com.duan.wanandroid.base.BaseContract;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/15
 */

public interface KnowView {
    interface View extends BaseContract.BaseView{
        void setrecycledata(List list);
    }
    interface Present extends BaseContract.BasePresenter<KnowView.View>{
        void getrecycle();
    }
}
