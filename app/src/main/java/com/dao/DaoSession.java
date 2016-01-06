package com.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig configDaoConfig;
    private final DaoConfig parentDaoConfig;

    private final ConfigDao configDao;
    private final ParentDao parentDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        configDaoConfig = daoConfigMap.get(ConfigDao.class).clone();
        configDaoConfig.initIdentityScope(type);

        parentDaoConfig = daoConfigMap.get(ParentDao.class).clone();
        parentDaoConfig.initIdentityScope(type);

        configDao = new ConfigDao(configDaoConfig, this);
        parentDao = new ParentDao(parentDaoConfig, this);

        registerDao(Config.class, configDao);
        registerDao(Parent.class, parentDao);
    }
    
    public void clear() {
        configDaoConfig.getIdentityScope().clear();
        parentDaoConfig.getIdentityScope().clear();
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }

    public ParentDao getParentDao() {
        return parentDao;
    }

}
