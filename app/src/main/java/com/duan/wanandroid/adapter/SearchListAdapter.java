package com.duan.wanandroid.adapter;

import android.text.Html;

import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.SearchListBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by Duan on 2019/11/19
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.adapter
 * @ClassName: SearchListAdapter
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/19 9:45
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/19 9:45
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SearchListAdapter extends BaseQuickAdapter<SearchListBean.DataBean.DatasBean, BaseViewHolder> {
    public SearchListAdapter(int layoutResId, @Nullable List<SearchListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchListBean.DataBean.DatasBean item) {
        if (!StringUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.main_title, Html.fromHtml(item.getTitle()));
        }
        helper.setText(R.id.main_author, "作者:" + item.getAuthor());
        helper.setText(R.id.main_sort, "分类:" + item.getChapterName());
        helper.setText(R.id.mian_time, "时间:" + item.getNiceDate());
        helper.addOnClickListener(R.id.tool_bar);
    }
}
