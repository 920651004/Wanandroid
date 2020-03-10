package com.duan.wanandroid.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duan.greenDao.HistoryData;
import com.duan.wanandroid.R;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by Duan on 2019/11/14
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.adapter
 * @ClassName: SearchAdapter
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/14 15:19
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/14 15:19
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SearchAdapter extends BaseQuickAdapter<HistoryData,BaseViewHolder>{
    public SearchAdapter(int layoutResId, @Nullable List<HistoryData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryData item) {
        helper.setText(R.id.search_item_text,item.getData());
    }
}
