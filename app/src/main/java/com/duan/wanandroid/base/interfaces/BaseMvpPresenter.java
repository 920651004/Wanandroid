package com.duan.wanandroid.base.interfaces;

import android.os.Bundle;

/**
 * Created by Duan on 2019/10/14.
 * <p>
 * P层接口基类
 */

public interface BaseMvpPresenter extends BasePresenter {

    /**
     * 初始化数据
     */
    void init();

    /**
     * 管理实例状态
     */
    void process(Bundle savedInstanceState);
}
