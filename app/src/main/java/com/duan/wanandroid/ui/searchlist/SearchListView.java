package com.duan.wanandroid.ui.searchlist;

import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.SearchListBean;

import java.util.List;

/**
 * Created by Duan on 2019/11/18
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.searchlist
 * @ClassName: SearchListView
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/18 15:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/18 15:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface SearchListView extends BaseMvpView {
    void SetListData(List<SearchListBean.DataBean.DatasBean> list);
}
