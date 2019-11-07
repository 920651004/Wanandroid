package com.duan.wanandroid.ui.fragment.wx;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;
import com.duan.wanandroid.base.interfaces.BaseMvpView;

/**
 * Created by Duan on 2019/11/5
 */
public interface WxChildPresent extends BaseMvpPresenter {
    void getListData(int id);
}
