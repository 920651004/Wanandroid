package com.duan.wanandroid.base.db;

import java.util.List;

/**
 * Created by Duan on 2019/11/7
 */
public interface DBHelper {
    /**
     * @author Duan
     * @time 2019/11/7  17:13
     * @describe 增加历史数据
     */
    List<HistoryData> addHistoryDdata(String data);

    /**
     * @author Duan
     * @time 2019/11/7  17:17
     * @describe 清理历史数据
     */
    void clearHistoryData();

    /**
     * @author Duan
     * @time 2019/11/7  17:18
     * @describe 加载历史数据
     */
    List<HistoryData> loadHistoryData();
}
