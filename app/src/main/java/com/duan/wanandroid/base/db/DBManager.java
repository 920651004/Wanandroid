package com.duan.wanandroid.base.db;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.duan.greenDao.DaoMaster;
import com.duan.greenDao.DaoSession;
import com.duan.greenDao.HistoryDataDao;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * @author Duan
 * @date 2020/11/16
 * Describe
 */
public class DBManager {
    private static DBManager DB;
    private DaoSession mDaoSession;

    public static void init(Application application) {
        if (DB == null) {
            DB=new DBManager(application,Contents.DB_Name);
        }
    }

    private DBManager(Application application, String dbName) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(application, dbName + "-db");
        Database db = helper.getWritableDb();
        if (Contents.DB_Name.equals(dbName)) {
            mDaoSession = new DaoMaster(db).newSession();
        }
    }

    public static DaoSession getDaoSession() {
        return DB.mDaoSession;
    }

    public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
        public MySQLiteOpenHelper(Context context, String name) {
            super(context, name);
        }

        public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    DaoMaster.createAllTables(db, ifNotExists);
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    DaoMaster.dropAllTables(db, ifExists);
                }
            }, HistoryDataDao.class);
        }
    }
    public static DbHelperImpl dbHelper(){
        return new DbHelperImpl();
    }
}
