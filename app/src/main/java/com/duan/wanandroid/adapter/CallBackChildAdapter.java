package com.duan.wanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.bean.Hostinfo;

import java.util.List;

/**
 * Created by Duan on 2019/11/28
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.adapter
 * @ClassName: CallBackChildAdapter
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/28 14:43
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/28 14:43
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CallBackChildAdapter extends BaseQuickAdapter<Hostinfo.ReportGroupConfigBean.ReportConfigBean,BaseViewHolder> {
    public CallBackChildAdapter(int layoutResId, @Nullable List<Hostinfo.ReportGroupConfigBean.ReportConfigBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Hostinfo.ReportGroupConfigBean.ReportConfigBean item) {

    }
}
