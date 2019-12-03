package com.duan.wanandroid.ui.search;

import com.duan.greenDao.HistoryData;
import com.duan.wanandroid.base.interfaces.BaseMvpPresenter;

import java.util.List;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.ui.search
 * @ClassName: SearchPresenter
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/8 15:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 15:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public interface SearchPresenter extends BaseMvpPresenter {

    void getHotText();

    List<HistoryData> LoadHistory();

    void clearHistory();

    void addHistory(String data);
}
