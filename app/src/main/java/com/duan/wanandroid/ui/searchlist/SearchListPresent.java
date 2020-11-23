package com.duan.wanandroid.ui.searchlist;

import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;

/**
 * Created by Duan on 2019/11/18
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.searchlist
 * @ClassName: SearchListPresent
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/18 15:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/18 15:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface SearchListPresent extends BaseMvpPresenter {
    void GetSearchListData(int page, String k);
}
