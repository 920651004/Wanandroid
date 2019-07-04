package com.duan.wanandroid.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.duan.greenDao.DaoSession;
import com.duan.greenDao.StuentBeanDao;
import com.duan.greenDao.MuchBeanDao;

/**
 * Created by yanfa-005 on 2018/12/24
 */
@Entity
public class MuchBean {
    @Id
    Long id;

    String name;
@ToMany(referencedJoinProperty = "mid")
    List<StuentBean> students;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 504794901)
private transient MuchBeanDao myDao;
@Generated(hash = 407786801)
public MuchBean(Long id, String name) {
    this.id = id;
    this.name = name;
}
@Generated(hash = 1110345532)
public MuchBean() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}
/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 501553882)
public List<StuentBean> getStudents() {
    if (students == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        StuentBeanDao targetDao = daoSession.getStuentBeanDao();
        List<StuentBean> studentsNew = targetDao._queryMuchBean_Students(id);
        synchronized (this) {
            if (students == null) {
                students = studentsNew;
            }
        }
    }
    return students;
}
/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 238993120)
public synchronized void resetStudents() {
    students = null;
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}
/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}
/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 446483511)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getMuchBeanDao() : null;
}


}
