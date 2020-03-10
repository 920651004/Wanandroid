package com.duan.wanandroid.base;

import android.content.Context;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;
import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.base.interfaces.LifeFul;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Duan on 2019/10/14.
 *
 * P层基类
 */

public abstract class BaseMvpPresenterImpl<T extends BaseMvpView> implements BaseMvpPresenter {
    //Activity context的弱引用，使用时注意判空
    private WeakReference<Context> mContextReference;
    private T view;
    private LifeFul lifeFul;
    //用于使用RxJava时，解除订阅
    protected List<Disposable> disposables;


    public BaseMvpPresenterImpl(Context context, T view, LifeFul lifeFul) {
        this.mContextReference = new WeakReference<>(context);
        this.view = view;
        this.lifeFul = lifeFul;
        this.disposables = new ArrayList<>();
    }

    @Override
    public void init() {
        getView().initView();
    }

    @Override
    public void destroy() {
        for (Disposable disposable : disposables) {
            if (disposable != null)
                disposable.dispose();
        }
    }

    /**
     * context的弱引用，使用时注意判空
     */
    @Nullable
    protected Context getContext() {
        return mContextReference.get();
    }

    protected T getView() {
        return view;
    }

    protected LifeFul getLifeFul() {
        return lifeFul;
    }
}
