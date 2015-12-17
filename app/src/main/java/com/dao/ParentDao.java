package com.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "PARENT".
*/
public class ParentDao extends AbstractDao<Parent, Long> {

    public static final String TABLENAME = "PARENT";

    /**
     * Properties of entity Parent.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Uid = new Property(1, String.class, "uid", false, "UID");
        public final static Property Token = new Property(2, String.class, "token", false, "TOKEN");
        public final static Property Phone = new Property(3, String.class, "phone", false, "PHONE");
        public final static Property Alias = new Property(4, String.class, "alias", false, "ALIAS");
        public final static Property Sex = new Property(5, Integer.class, "sex", false, "SEX");
        public final static Property Birthday = new Property(6, Long.class, "birthday", false, "BIRTHDAY");
        public final static Property HeadThumb = new Property(7, String.class, "headThumb", false, "HEAD_THUMB");
    };


    public ParentDao(DaoConfig config) {
        super(config);
    }
    
    public ParentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PARENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"UID\" TEXT," + // 1: uid
                "\"TOKEN\" TEXT," + // 2: token
                "\"PHONE\" TEXT," + // 3: phone
                "\"ALIAS\" TEXT," + // 4: alias
                "\"SEX\" INTEGER," + // 5: sex
                "\"BIRTHDAY\" INTEGER," + // 6: birthday
                "\"HEAD_THUMB\" TEXT);"); // 7: headThumb
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PARENT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Parent entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String uid = entity.getUid();
        if (uid != null) {
            stmt.bindString(2, uid);
        }
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(3, token);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
 
        String alias = entity.getAlias();
        if (alias != null) {
            stmt.bindString(5, alias);
        }
 
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(6, sex);
        }
 
        Long birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindLong(7, birthday);
        }
 
        String headThumb = entity.getHeadThumb();
        if (headThumb != null) {
            stmt.bindString(8, headThumb);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Parent readEntity(Cursor cursor, int offset) {
        Parent entity = new Parent( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // uid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // token
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // phone
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // alias
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // sex
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // birthday
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // headThumb
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Parent entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setToken(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAlias(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSex(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setBirthday(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setHeadThumb(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Parent entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Parent entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
