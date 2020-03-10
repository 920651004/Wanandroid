package com.duan.wanandroid.base;

import android.content.Context;
import android.os.Bundle;

import com.duan.wanandroid.base.interfaces.BaseView;
import com.duan.wanandroid.base.interfaces.LifeFul;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Duan on 2019/10/14.
 * <p>
 * 所有Activity基类
 */

public abstract class BaseAppCompatActivity extends SupportActivity implements BaseView, LifeFul {
    protected boolean isDestroyed = false;
    private Unbinder unbind;

    public Context mContext;

    @Nullable
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        unbind = ButterKnife.bind(this);
        mContext = this;
        init();

        process(savedInstanceState);
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
    public boolean isAlive() {
        return activityIsAlive();
    }

    @Override
    protected void onDestroy() {
        isDestroyed = true;
        unbind.unbind();
        mContext = null;
        super.onDestroy();
    }

    /**
     * 判断当前activity是否被销毁
     */
    public boolean isDestroyed() {
        return super.isDestroyed() || isDestroyed;
    }

    /**
     * 判断当前activity是否存活
     */
    public boolean activityIsAlive() {
        return getBaseContext() != null && !(this.isDestroyed() || this.isFinishing());
    }

    /**
     * 页面布局ID
     */
    public abstract @LayoutRes
    int getLayoutId();
}
