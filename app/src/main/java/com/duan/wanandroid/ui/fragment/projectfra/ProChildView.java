package com.duan.wanandroid.ui.fragment.projectfra;

import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.ProchildBean;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/21
 */

public interface ProChildView extends BaseMvpView {

         void getdata(List<ProchildBean.DataBean.DatasBean> list);

}
