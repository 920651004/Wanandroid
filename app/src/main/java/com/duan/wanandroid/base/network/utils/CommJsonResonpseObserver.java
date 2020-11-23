package com.duan.wanandroid.base.network.utils;


import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.google.gson.JsonSyntaxException;


import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Duan on 2019/10/14.
 * <p>
 * Json返回体观察者，处理服务器返回体，包含Response相关信息
 */

public abstract class CommJsonResonpseObserver<T> implements Observer<CommJsonEntity<T>> {

    //当前判断网络请求绑定的Activity是否存活
    private LifeFul lifeFul;

    public CommJsonResonpseObserver(LifeFul lifeFul) {
        this.lifeFul = lifeFul;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        if (lifeFul != null && !lifeFul.isAlive()) {
            disposable.dispose();
        }
    }

    @Override
    public void onNext(CommJsonEntity<T> value) {
        if (lifeFul == null || lifeFul.isAlive()) {
            if (value.isSuccess()) {
                onSuccess(value.getData());
            } else {
                onError(value.getCode(), value.getMsg());
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (lifeFul == null || lifeFul.isAlive()) {
            onError(-1, getErrorMessage(e));
        }
    }

    @Override
    public void onComplete() {

    }

    private String getErrorMessage(Throwable e) {
        if (e instanceof JsonSyntaxException) {
            LogUtils.e(e.toString());
            return "数据解析失败";
        } else if (e instanceof UnknownHostException) {
            LogUtils.e(e.toString());
            return "网络连接中断";
        } else if (e instanceof SocketTimeoutException) {
            LogUtils.e(e.toString());
            return "服务器繁忙";
        } else {
            LogUtils.e(e.toString());
            return "其它异常: " + e.getClass();
        }
    }

    public abstract void onSuccess(T t);

    public abstract void onError(int errorCode, String message);
}
