package com.duan.wanandroid.ui.fragment.projectfra;

import com.duan.wanandroid.base.BaseContract;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/20
 */

public class ProView {
    interface  View extends BaseContract.BaseView{
        void settabdata(List list,List data);
        void setlistdata(List list);
    }
    interface  Present extends BaseContract.BasePresenter<ProView.View>{
        void  getdata();
    }
}
