package com.duan.wanandroid.base.db;

import com.blankj.utilcode.util.TimeUtils;
import com.duan.greenDao.DaoSession;
import com.duan.greenDao.HistoryDataDao;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.greenDao.db
 * @ClassName: DbHelperImpl
 * @Description: java类作用描述
 * @Author: Duan
 * @CreateDate: 2019/11/8 9:28
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 9:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DbHelperImpl implements DBHelper {
    private DaoSession daoSession;
    private HistoryData historyData;
    private List<HistoryData> historyDataList;
    private String data;
    private static final int HISTORY_LIST_SIZE = 10;
    public DbHelperImpl() {
        this.daoSession =  DBManager.getDaoSession();
    }

    @Override
    public List<HistoryData> addHistoryDdata(String data) {
        this.data = data;
        getHistoryData();
        creatHistoryData();
        if (RemoveSameData()){
            return historyDataList;
        }
        if (historyDataList.size()<HISTORY_LIST_SIZE){
            getHistoryDataDao().insert(historyData);
        }else {
            historyDataList.remove(0);
            historyDataList.add(historyData);
            getHistoryDataDao().deleteAll();
            getHistoryDataDao().insertInTx(historyDataList);
        }
        return historyDataList;
    }

    /**
     * @author Duan
     * @time 2019/11/8  14:32
     * @describe 清除数据
     */
    @Override
    public void clearHistoryData() {
        daoSession.getHistoryDataDao().deleteAll();
    }

    private void getHistoryData() {
        historyDataList = getHistoryDataDao().loadAll();
    }

    @Override
    public List<HistoryData> loadHistoryData() {
        return daoSession.getHistoryDataDao().loadAll();
    }

    /**
     * @author Duan
     * @time 2019/11/8  14:29
     * @describe 移除相同的数据
     */
    private boolean RemoveSameData() {
        Iterator<HistoryData> iterator = historyDataList.iterator();
        while (iterator.hasNext()) {
            HistoryData historyData = iterator.next();
            if (historyData.getData().equals(data)) {
                iterator.remove();
                historyDataList.add(historyData);
                getHistoryDataDao().deleteAll();
                getHistoryDataDao().insertInTx(historyDataList);
                return true;
            }
        }
        return false;
    }

    private void creatHistoryData() {
        historyData = new HistoryData();
        historyData.setDate(TimeUtils.getNowMills());
        historyData.setData(data);
    }
    private HistoryDataDao getHistoryDataDao() {
        return daoSession.getHistoryDataDao();
    }
}
