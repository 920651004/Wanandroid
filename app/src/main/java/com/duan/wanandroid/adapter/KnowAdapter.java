package com.duan.wanandroid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.KnowBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

/**
 * Created by yanfa-005 on 2018/11/15
 */

public class KnowAdapter extends BaseQuickAdapter<KnowBean.DataBean, BaseViewHolder> {
    List<String> list;

    public KnowAdapter(@LayoutRes int layoutResId, @Nullable List<KnowBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowBean.DataBean item) {
        helper.setText(R.id.kno_title, item.getName());
        list = new ArrayList<>();
        for (KnowBean.DataBean.ChildrenBean childrenBean : item.getChildren()) {
            list.add(childrenBean.getName());
        }
        String name = list.toString().replace("[", "");
        name = name.replace("]", "");
        name = name.replace(",", " ");
        helper.setText(R.id.kno_text, name);
    }
}
