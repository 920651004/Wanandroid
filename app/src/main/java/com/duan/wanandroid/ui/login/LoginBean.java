package com.duan.wanandroid.ui.login;

/**
 * Created by yanfa-005 on 2018/10/16
 */

public class LoginBean {

    /**
     * data : null
     * errorCode : -1
     * errorMsg : 账号密码不匹配！
     */

    private Object data;
    private int errorCode;
    private String errorMsg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
