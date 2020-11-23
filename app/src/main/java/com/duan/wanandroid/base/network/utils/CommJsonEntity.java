package com.duan.wanandroid.base.network.utils;

import java.io.Serializable;

/**
 * Created by Duan on 2019/10/14.
 * <p>
 * 返回体基类，包含http code和msg
 */

class CommJsonEntity<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    String getMsg() {
        return msg;
    }

    void setMsg(String msg) {
        this.msg = msg;
    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    boolean isSuccess() {
        return this.code == 200;
    }
}
