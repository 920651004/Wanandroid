package com.duan.wanandroid.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.NavBean;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/11/16
 */

public class NavAdapter extends BaseQuickAdapter<NavBean.DataBean,BaseViewHolder> {
    TextView textView;
    public NavAdapter(@LayoutRes int layoutResId, @Nullable List<NavBean.DataBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, NavBean.DataBean item) {
        helper.setText(R.id.nav_text,item.getName());
        helper.addOnClickListener(R.id.nav_text);
        textView=helper.getView(R.id.nav_text);
        if (item.isCheck()){
            helper.getView(R.id.tool_bar).setBackgroundColor(mContext.getResources().getColor(R.color.white));

            textView.setTextColor(mContext.getResources().getColor(R.color.blue));
        }else {
            helper.getView(R.id.tool_bar).setBackgroundColor(mContext.getResources().getColor(R.color.blue));
            textView.setTextColor(mContext.getResources().getColor(R.color.white));
        }
    }
}
