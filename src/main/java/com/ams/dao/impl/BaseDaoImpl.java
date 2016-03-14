package com.ams.dao.impl;

import com.ams.dao.BaseDao;
import com.ams.util.ReflectionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by Evan on 2016/3/12.
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    private Class<?> entityClass;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    protected BaseDao<T, PK> getBaseDao() {
        SqlSession session = sqlSessionFactory.openSession();
        entityClass = ReflectionUtil.getMatcherMapper(getClass());
        @SuppressWarnings("unchecked")
        BaseDao<T, PK> baseDao = (BaseDao<T, PK>) session
                .getMapper(entityClass);
        return baseDao;
    }


    @Override
    public void insert(T entity) {
        getBaseDao().insert(entity);
    }

    @Override
    public void delete(PK primaryKey) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public T findById(PK primaryKey) {
        return null;
    }
}
