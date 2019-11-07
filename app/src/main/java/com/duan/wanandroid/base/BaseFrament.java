package com.duan.wanandroid.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.interfaces.BaseView;
import com.duan.wanandroid.base.interfaces.LifeFul;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Duan on 2019/10/23
 */
public abstract class BaseFrament extends SupportFragment implements BaseView,LifeFul{
    private Unbinder unbind;
    Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(getLayoutId(),container,false);
        unbind= ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        process(savedInstanceState);
        init();
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(String msg) {

    }

    /**
     * 初始化
     */
    protected void init() {

    }

    /**
     * 逻辑处理
     */
    protected void process(Bundle savedInstanceState) {

    }
    @Override
    public void onDestroyView() {
        unbind.unbind();
        super.onDestroyView();
    }

    @Override
    public boolean isAlive() {
        return activityIsAlive();
    }
    /**
     * 判断当前Frament是否被销毁
     */

    public boolean isDestroyed() {
        return super.getActivity().isDestroyed();
    }

    /**
     * 判断宿主Frament是否存活
     */
    public boolean activityIsAlive() {
        return getActivity()!=null && !(this.isDestroyed()||getActivity().isFinishing()) ;
    }

    /**
     * 页面布局ID
     */
    protected abstract @LayoutRes
    int getLayoutId();
}
