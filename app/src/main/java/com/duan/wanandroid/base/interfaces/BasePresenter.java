package com.duan.wanandroid.base.interfaces;

/**
 * Created by Duan on 2019/10/14.
 *
 *
 */

public interface BasePresenter {

    /**
     * 绑定Activity onResume
     */
    void resume();

    /**
     * 绑定Activity onPause
     */
    void pause();

    /**
     * 绑定Activity onDestroy
     */
    void destroy();
}
