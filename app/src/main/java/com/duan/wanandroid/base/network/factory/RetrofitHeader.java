package com.duan.wanandroid.base.network.factory;

/**
 * Created by Duan on 2019/10/12.
 * <p>
 * Retrofit自定义头
 */

public class RetrofitHeader {
    static final String SERVER = "Server";
    static final String CA_SERVER = "CA_Server";
    static final String BUSINESS_SERVER = "Business_Server";

    //使用CA服务器
    public static final String CA = SERVER + ":" + CA_SERVER;
    //使用业务服务器
    public static final String BUSINESS = SERVER + ":" + BUSINESS_SERVER;
}
