package com.duan.wanandroid.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.NavBean;
import com.duan.wanandroid.utlis.CommonUtils;
import com.duan.wanandroid.utlis.JsonUtil;
import com.duan.wanandroid.utlis.JumpUtlis;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by yanfa-005 on 2018/11/16
 */

public class NavChildAdapter extends BaseQuickAdapter<NavBean.DataBean, BaseViewHolder> {
    List<NavBean.DataBean.ArticlesBean> list = new ArrayList<>();
    TagFlowLayout tagFlowLayout;

    public NavChildAdapter(@LayoutRes int layoutResId, @Nullable List<NavBean.DataBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, NavBean.DataBean item) {
        // helper.setText(R.id.nav_child_text,item.getTitle());
        LogUtils.e(JsonUtil.toJson(item));
        list = new ArrayList<>();
        list.addAll(item.getArticles());
        tagFlowLayout = helper.getView(R.id.nav_child_tag);
        tagFlowLayout.setAdapter(new TagAdapter<NavBean.DataBean.ArticlesBean>(list) {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public View getView(FlowLayout parent, int position, NavBean.DataBean.ArticlesBean articlesBean) {
                TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.flow_layout_tv,
                        tagFlowLayout, false);
                String name = articlesBean.getTitle();
                tv.setPadding(30, 30,
                        30, 30);
                tv.setText(name);
                tv.setTextColor(CommonUtils.randomColor());
                tagFlowLayout.setOnTagClickListener((view, position1, parent1) -> {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, view, mContext.getString(R.string.tranname));
                    JumpUtlis.ToWebDetial(mContext,
                            list.get(position).getLink(),
                            list.get(position).getTitle(),
                            options);
                    return true;
                });
                return tv;
            }
        });

    }

}
