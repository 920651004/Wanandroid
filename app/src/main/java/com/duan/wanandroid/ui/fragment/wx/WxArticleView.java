package com.duan.wanandroid.ui.fragment.wx;

import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.WxArticle;

import java.util.List;

/**
 * Created by Duan on 2019/11/5
 */
public interface WxArticleView  extends BaseMvpView{
    void setTablayoutData(List<WxArticle.DataBean> list,List<String> mlist);
}
