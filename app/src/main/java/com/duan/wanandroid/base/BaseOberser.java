package com.duan.wanandroid.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by Admin on 2020/3/12
 * lifecycle监测生命周期
 */
public class BaseOberser implements LifecycleObserver  {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {

    }


}
