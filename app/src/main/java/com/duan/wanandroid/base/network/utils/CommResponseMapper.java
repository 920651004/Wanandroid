package com.duan.wanandroid.base.network.utils;

import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by Duan on 2019/10/14.
 *
 * Http Response转换成CommJsonEntity
 */

public class CommResponseMapper<T> implements Function<Response<T>, CommJsonEntity<T>> {

    @Override
    public CommJsonEntity<T> apply(Response<T> response) {
        CommJsonEntity<T> entity = new CommJsonEntity<>();
        entity.setData(response.body());
        entity.setCode(response.code());
        entity.setMsg(response.message());
        return entity;
    }
}