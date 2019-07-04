package com.duan.wanandroid.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseApplication;
import com.duan.wanandroid.bean.ProchildBean;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/21
 */

public class ProchilAdapter extends BaseQuickAdapter<ProchildBean.DataBean.DatasBean,BaseViewHolder> {
    public ProchilAdapter(@LayoutRes int layoutResId, @Nullable List<ProchildBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProchildBean.DataBean.DatasBean item) {
        helper.setText(R.id.pro_author,item.getAuthor());
        helper.setText(R.id.pro_explain,item.getDesc());
        helper.setText(R.id.pro_title,item.getTitle());
        helper.setText(R.id.pro_time,item.getNiceDate());
        helper.addOnClickListener(R.id.tool_bar);
        Glide.with(mContext)
                .load(item.getEnvelopePic())
                .crossFade()
                .into((ImageView) helper.getView(R.id.pro_image));
    }
}
