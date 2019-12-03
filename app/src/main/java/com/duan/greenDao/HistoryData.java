package com.duan.greenDao;

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

    @Generated(hash = 719141379)
    public HistoryData(Long ID, Long Date, String Data) {
        this.ID = ID;
        this.Date = Date;
        this.Data = Data;
    }

    @Generated(hash = 422767273)
    public HistoryData() {
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getDate() {
        return Date;
    }

    public void setDate(Long date) {
        Date = date;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
