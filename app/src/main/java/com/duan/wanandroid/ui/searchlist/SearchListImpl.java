package com.duan.wanandroid.ui.searchlist;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.SearchListBean;

/**
 * Created by Duan on 2019/11/18
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.searchlist
 * @ClassName: SearchListImpl
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/18 15:33
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/18 15:33
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SearchListImpl extends BaseMvpPresenterImpl<SearchListView> implements SearchListPresent {

    public SearchListImpl(Context context, SearchListView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
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

    @Override
    public void GetSearchListData(int page, String k) {
        getView().showLoading();
        SearchListBean.GetList(page, k, new CommJsonObserver<SearchListBean>(getLifeFul()) {
            @Override
            public void onSuccess(SearchListBean searchListBean) {
                getView().hideLoading();
                getView().SetListData(searchListBean.getData().getDatas());
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                ToastUtils.showShort(message);
            }
        });
    }
}
