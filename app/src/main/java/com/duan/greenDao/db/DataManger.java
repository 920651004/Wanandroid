package com.duan.greenDao.db;

import com.blankj.utilcode.util.LogUtils;
import com.duan.greenDao.HistoryData;
import com.duan.wanandroid.utlis.JsonUtil;

import java.util.List;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.greenDao.db
 * @ClassName: DataManger
 * @Description: 用于数据库操作
 * @Author: Duan
 * @CreateDate: 2019/11/8 15:16
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 15:16
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DataManger implements DBHelper {
    private DbHelperImpl dbHelper;
    public DataManger(DbHelperImpl helper) {
        dbHelper=helper;
    }

    @Override
    public List<HistoryData> addHistoryDdata(String data) {
        return dbHelper.addHistoryDdata(data);
    }

    @Override
    public void clearHistoryData() {
        dbHelper.clearHistoryData();
    }

    @Override
    public List<HistoryData> loadHistoryData() {
        return dbHelper.loadHistoryData();
    }
}
