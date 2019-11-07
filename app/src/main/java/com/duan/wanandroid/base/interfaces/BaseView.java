package com.duan.wanandroid.base.interfaces;

/**
 * Created by Duan on 2019/10/14.
 */

public interface BaseView {

    /**
     * 通知View展示默认的弹窗
     */
    void showLoading();

    /**
     * 通知View展示带消息的弹窗，msg == null 时不显示文字
     */
    void showLoading(String msg);

    /**
     * 通知View关闭弹窗
     */
    void hideLoading();

    /**
     * 通知View展示消息
     */
    void showMsg(String msg);
}
