package com.duan.greenDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HISTORY_DATA".
*/
public class HistoryDataDao extends AbstractDao<HistoryData, Long> {

    public static final String TABLENAME = "HISTORY_DATA";

    /**
     * Properties of entity HistoryData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ID = new Property(0, Long.class, "ID", true, "_id");
        public final static Property Date = new Property(1, Long.class, "Date", false, "DATE");
        public final static Property Data = new Property(2, String.class, "Data", false, "DATA");
    }


    public HistoryDataDao(DaoConfig config) {
        super(config);
    }
    
    public HistoryDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HISTORY_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: ID
                "\"DATE\" INTEGER," + // 1: Date
                "\"DATA\" TEXT);"); // 2: Data
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HISTORY_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HistoryData entity) {
        stmt.clearBindings();
 
        Long ID = entity.getID();
        if (ID != null) {
            stmt.bindLong(1, ID);
        }
 
        Long Date = entity.getDate();
        if (Date != null) {
            stmt.bindLong(2, Date);
        }
 
        String Data = entity.getData();
        if (Data != null) {
            stmt.bindString(3, Data);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HistoryData entity) {
        stmt.clearBindings();
 
        Long ID = entity.getID();
        if (ID != null) {
            stmt.bindLong(1, ID);
        }
 
        Long Date = entity.getDate();
        if (Date != null) {
            stmt.bindLong(2, Date);
        }
 
        String Data = entity.getData();
        if (Data != null) {
            stmt.bindString(3, Data);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HistoryData readEntity(Cursor cursor, int offset) {
        HistoryData entity = new HistoryData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // ID
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // Date
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // Data
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HistoryData entity, int offset) {
        entity.setID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDate(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setData(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HistoryData entity, long rowId) {
        entity.setID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HistoryData entity) {
        if(entity != null) {
            return entity.getID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HistoryData entity) {
        return entity.getID() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
