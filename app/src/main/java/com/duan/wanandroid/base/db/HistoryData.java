package com.duan.wanandroid.base.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Duan on 2019/11/7
 */
@Entity
public class HistoryData {
    //历史数据id
    @Id(autoincrement = true)
    private Long ID;
    //历史数据时间
    private Long Date;
    //历史数据
    private String Data;
    private String DTest;
    private int num;
    @Generated(hash = 1405178364)
    public HistoryData(Long ID, Long Date, String Data, String DTest, int num) {
        this.ID = ID;
        this.Date = Date;
        this.Data = Data;
        this.DTest = DTest;
        this.num = num;
    }
    @Generated(hash = 422767273)
    public HistoryData() {
    }
    public Long getID() {
        return this.ID;
    }
    public void setID(Long ID) {
        this.ID = ID;
    }
    public Long getDate() {
        return this.Date;
    }
    public void setDate(Long Date) {
        this.Date = Date;
    }
    public String getData() {
        return this.Data;
    }
    public void setData(String Data) {
        this.Data = Data;
    }
    public String getDTest() {
        return this.DTest;
    }
    public void setDTest(String DTest) {
        this.DTest = DTest;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }



}
