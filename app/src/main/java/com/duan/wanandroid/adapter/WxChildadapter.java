package com.duan.wanandroid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.WxArticleByOrder;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

/**
 * Created by yanfa-005 on 2018/11/7
 */

public class WxChildadapter extends BaseQuickAdapter<WxArticleByOrder.DataBean.DatasBean, BaseViewHolder> {
    public WxChildadapter(@LayoutRes int layoutResId, @Nullable List<WxArticleByOrder.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WxArticleByOrder.DataBean.DatasBean item) {
        helper.setText(R.id.main_title, item.getTitle());
        helper.setText(R.id.main_author, "作者:" + item.getAuthor());
        helper.setText(R.id.main_sort, "分类:" + item.getChapterName());
        helper.setText(R.id.mian_time, "时间:" + item.getNiceDate());
        helper.addOnClickListener(R.id.tool_bar);
    }
}
