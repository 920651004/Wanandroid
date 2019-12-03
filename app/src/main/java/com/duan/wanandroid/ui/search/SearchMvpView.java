package com.duan.wanandroid.ui.search;

import com.duan.wanandroid.base.interfaces.BaseMvpView;
import com.duan.wanandroid.bean.HotText;

import java.util.List;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.search
 * @ClassName: SearchMvpView
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/8 15:33
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 15:33
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface SearchMvpView extends BaseMvpView {
    void setHotInfo(List<HotText.DataBean> hotList);
}
