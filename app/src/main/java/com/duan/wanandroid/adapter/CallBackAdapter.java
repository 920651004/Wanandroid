package com.duan.wanandroid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.wanandroid.R;
import com.duan.wanandroid.bean.Hostinfo;
import com.duan.wanandroid.utlis.CallBack;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Duan on 2019/11/28
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.adapter
 * @ClassName: CallBackAdapter
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/28 14:41
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/28 14:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CallBackAdapter extends BaseQuickAdapter<Hostinfo.ReportGroupConfigBean, BaseViewHolder> {
    CallBackChildAdapter adapter;
    RecyclerView CallBackRv;
    CallBack back;

    public CallBackAdapter(int layoutResId, @Nullable List<Hostinfo.ReportGroupConfigBean> data, CallBack callBack) {
        super(layoutResId, data);
        back = callBack;

    }

    @Override
    protected void convert(BaseViewHolder helper, Hostinfo.ReportGroupConfigBean item) {
        CallBackRv = helper.getView(R.id.call_back_chid_rv);
        adapter = new CallBackChildAdapter(R.layout.item_callback_child, item.getReportConfig());
        back.setAdapter(adapter);
    }

}



