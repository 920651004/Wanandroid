package com.duan.wanandroid.ui.search;

import android.content.Context;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.base.BaseMvpPresenterImpl;
import com.duan.wanandroid.base.db.DataManger;
import com.duan.wanandroid.base.db.DbHelperImpl;
import com.duan.wanandroid.base.db.HistoryData;
import com.duan.wanandroid.base.interfaces.LifeFul;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;
import com.duan.wanandroid.bean.HotText;

import java.util.List;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.search
 * @ClassName: SearchListImpl
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/8 16:04
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 16:04
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SearchImpl extends BaseMvpPresenterImpl<SearchMvpView> implements SearchPresenter {
    DataManger dbManger;

    public SearchImpl(Context context, SearchMvpView view, LifeFul lifeFul) {
        super(context, view, lifeFul);
        dbManger = new DataManger(new DbHelperImpl());
    }

    @Override
    public void getHotText() {
        getView().showLoading();
        HotText.getHotTextinfo(new CommJsonObserver<HotText>(getLifeFul()) {
            @Override
            public void onSuccess(HotText hotText) {
                getView().hideLoading();
                if (hotText.getErrorCode() == 0) {
                    getView().setHotInfo(hotText.getData());
                }
            }

            @Override
            public void onError(int errorCode, String message) {
                getView().hideLoading();
                ToastUtils.showShort(message);
            }
        });
    }

    @Override
    public List<HistoryData> LoadHistory() {
        return dbManger.loadHistoryData();
    }

    @Override
    public void clearHistory() {
        dbManger.clearHistoryData();
    }

    @Override
    public void addHistory(String data) {
        dbManger.addHistoryDdata(data);
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
