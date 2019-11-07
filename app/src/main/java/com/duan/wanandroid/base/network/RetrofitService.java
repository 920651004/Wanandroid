package com.duan.wanandroid.base.network;

import com.duan.wanandroid.base.network.factory.RetrofitHeader;
import com.duan.wanandroid.bean.KnowBean;
import com.duan.wanandroid.bean.MainRecycleBean;
import com.duan.wanandroid.bean.Mainfrabean;
import com.duan.wanandroid.bean.NavBean;
import com.duan.wanandroid.bean.Probean;
import com.duan.wanandroid.bean.ProchildBean;
import com.duan.wanandroid.bean.WxArticle;
import com.duan.wanandroid.bean.WxArticleByOrder;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Duan on 2019/10/9.
 */

public interface RetrofitService {

    @Headers(RetrofitHeader.CA)
    @GET("/ca_ip/text")
    Observable<ResponseBody> caTest(@Path("value") String value);

    @Headers(RetrofitHeader.BUSINESS)
    @GET("/normal_ip/text")
    Observable<ResponseBody> namalTest(@Path("value") String value);

    @GET("article/list/{num}/json")
    Observable<MainRecycleBean> MainRecycle(@Path("num") int num);

    @GET("banner/json")
    Observable<Mainfrabean> Banner();

    @GET("tree/json")
    Observable<KnowBean> KnoInfo();

    @GET("navi/json")
    Observable<NavBean> NavInfo();

    @GET("project/tree/json")
    Observable<Probean> ProInfo();

    @GET("project/list/{num}/json")
    Observable<ProchildBean> ProChildInfo(@Path("num") int num, @Query("cid") int id);

    @GET("wxarticle/chapters/json")
    Observable<WxArticle> WX_ARTICLE_OBSERVABLE();

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WxArticleByOrder> ARTICLE(@Path("id") int id, @Path("page") int page);

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WxArticleByOrder> ARTICLE_BY_ORDER_OBSERVABLE(@Path("id") int id, @Path("page") int page, @Query("k") String k);
}
