package com.duan.wanandroid.ui.fragment.wx;

import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.WxArticleByOrder;

import java.util.List;

/**
 * Created by Duan on 2019/11/5
 */
public interface WxchildView extends BaseMvpView {
    void setListData(List<WxArticleByOrder.DataBean.DatasBean> list);
}
