package com.duan.wanandroid.ui.fragment.projectfra;

import com.duan.wanandroid.base.BaseContract;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/21
 */

public class ProChildView {
    interface  View extends BaseContract.BaseView{
         void getdata(List list);
    }
    interface Present extends BaseContract.BasePresenter<ProChildView.View>{
        void setdata(int  id);
    }
}
