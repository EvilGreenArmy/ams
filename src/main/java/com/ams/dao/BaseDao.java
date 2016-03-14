package com.ams.dao;

import java.io.Serializable;

/**
 * 通用DAO接口.
 *
 * @param <T>
 * @param <PK>
 * @author Evan on 2016/3/12.
 */
public interface BaseDao<T, PK extends Serializable> {
    /**
     * 插入一个实体.
     *
     * @param entity
     */
    void insert(T entity);

    /**
     * 根据实体主键删除一个实体.
     *
     * @param primaryKey
     */
    void delete(PK primaryKey);

    /**
     * 更新一个实体.
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据主键获取一个实体
     *
     * @param primaryKey
     * @return
     */
    T findById(PK primaryKey);

}
