package com.duan.wanandroid.ui.fragment.wx;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.WxArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2019/11/5
 */
public class WxArticleImpl extends BaseMvpPresenterImpl<WxArticleView> implements WxActiclePresent{
    public WxArticleImpl(Context context, WxArticleView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
    }

    @Override
    public void getTabLayoutData() {
        getView().showLoading();
        WxArticle.WxInfo(new CommJsonObserver<WxArticle>(getLifeFul()) {
            @Override
            public void onSuccess(WxArticle wxArticle) {
                getView().hideLoading();
                if (wxArticle.getErrorCode()==0){
                    List<String> list=new ArrayList<>();
                    for (WxArticle.DataBean dataBean : wxArticle.getData()) {
                        list.add(dataBean.getName());
                    }
                    getView().setTablayoutData(wxArticle.getData(),list);
                }else {
                    ToastUtils.showShort(wxArticle.getErrorMsg());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                getView().showMsg("请求失败请重试");
            }
        });
    }

    @Override
    public void process(Bundle savedInstanceState) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
