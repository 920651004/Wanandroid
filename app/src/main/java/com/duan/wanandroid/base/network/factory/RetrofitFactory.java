package com.duan.wanandroid.base.network.factory;

import android.text.TextUtils;
import android.util.ArrayMap;


import com.duan.wanandroid.base.BaseApplication;
import com.duan.wanandroid.base.network.RetrofitService;
import com.duan.wanandroid.base.network.utils.LoggerInterceptor;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Duan on 2019/10/9.
 * <p>
 * Retrofit工厂
 */

public class RetrofitFactory {
    private static final String BaseUrl = "https://www.wanandroid.com/";

    private String CA_ARG;
    private String CA_IP;
    private String CA_PORT;
    private String BUSINESS_ARG;
    private String BUSINESS_IP;
    private String BUSINESS_PORT;

    private RetrofitService retrofitService;

    private static class Holder {
        private static RetrofitFactory instance = new RetrofitFactory();
    }

    private RetrofitFactory() {
        retrofitService = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(RetrofitService.class);
    }

    public static RetrofitService getInstance() {
        return Holder.instance.retrofitService;
    }

    /**
     * 设置CA服务ip端口
     */
    public static void setCAInfo(String CA_IP, String CA_PORT) {
        Holder.instance.CA_IP = CA_IP;
        Holder.instance.CA_PORT = CA_PORT;
        Holder.instance.CA_ARG = "https";
    }

    /**
     * 设置业务服务ip端口
     */
    public static void setBusinessInfo(String BUSINESS_IP, String BUSINESS_PORT) {
        Holder.instance.BUSINESS_IP = BUSINESS_IP;
        Holder.instance.BUSINESS_PORT = BUSINESS_PORT;
        Holder.instance.BUSINESS_ARG = "http";
    }

    /**
     * 设置OkHttpClient
     */
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        //  .addInterceptor(getHeaderInterceptor());
        builder.hostnameVerifier(new SafeHostnameVerifier());
        if (BaseApplication.isDebug) {
            LoggerInterceptor interceptor = new LoggerInterceptor("Retrofit");
            interceptor.setPrintLevel(LoggerInterceptor.Level.BODY);
            interceptor.setColorLevel(Level.WARNING);
            builder.addInterceptor(interceptor);
        }
        return builder.build();
    }

    /**
     * 自定义请求头拦截器
     */
    private Interceptor getHeaderInterceptor() {
        return chain -> {
            Request oldRequest = chain.request();
            Request.Builder newRequest = oldRequest.newBuilder();

            List<String> server = oldRequest.headers(RetrofitHeader.SERVER);
            if (server.size() == 0) {
                //每条链接必须设置服务器类型
                String url = oldRequest.url().toString();
                throw new NullPointerException("链接未设置服务器类型 : " + url);
            }

            //实例化IP，端口，协议
            String ip, port, agreement;
            if (RetrofitHeader.CA_SERVER.equals(server.get(0))) {
                ip = CA_IP;
                port = CA_PORT;
                agreement = CA_ARG;

                if (TextUtils.isEmpty(ip) || TextUtils.isEmpty(port)) {
                    throw new NullPointerException("CA服务IP，PORT未初始化");
                }
            } else {
                ip = BUSINESS_IP;
                port = BUSINESS_PORT;
                agreement = BUSINESS_ARG;

                if (TextUtils.isEmpty(ip) || TextUtils.isEmpty(port)) {
                    throw new NullPointerException("业务服务IP，PORT未初始化");
                }
            }

            //移除自定义请求头
            newRequest.removeHeader(RetrofitHeader.SERVER);

            //构建新的链接
            String baseUrl = agreement + "://" + ip + ":" + port + "/";
            HttpUrl newBaseUrl = HttpUrl.parse(baseUrl);

            if (newBaseUrl != null) {
                HttpUrl newUrl = oldRequest.url()
                        .newBuilder()
                        .scheme(newBaseUrl.scheme())
                        .host(newBaseUrl.host())
                        .port(newBaseUrl.port())
                        .build();
                return chain.proceed(newRequest.url(newUrl).build());
            }
            return chain.proceed(oldRequest);
        };
    }

    private static class SafeHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            //验证主机名是否匹配
            //return hostname.equals("server.jeasonlzy.com");
            return true;
        }
    }
}
