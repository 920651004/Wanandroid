package com.duan.wanandroid.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by yanfa-005 on 2018/12/24
 */
@Entity
public class StuentBean {
    @Id
    Long sid;
    Long mid;
    String name;
    @Generated(hash = 1960507417)
    public StuentBean(Long sid, Long mid, String name) {
        this.sid = sid;
        this.mid = mid;
        this.name = name;
    }
    @Generated(hash = 1497704111)
    public StuentBean() {
    }
    public Long getSid() {
        return this.sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
    public Long getMid() {
        return this.mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
