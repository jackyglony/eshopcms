package com.eshop.dao;

import java.io.Serializable;
import java.util.List;

import com.eshop.commons.Pager;

public interface Idao<T, PK extends Serializable> {
	/**
	 * 添加
	 * @param entity
	 */
	public void save(T entity);
	/**
	 * 删除
	 * @param entityClass
	 * @param pk
	 */
	public void delete(Class<T> entityClass, PK pk);
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 查询，按ID
	 * @param entityClass
	 * @param pk
	 * @return
	 */
	public T findById(Class<T> entityClass, PK pk);
	/**
	 * 查询全部信息
	 * @param entityClass
	 * @return
	 */
	public List<T> findAll(Class<T> entityClass);
	
	/**
	 * 分页
	 * @param entityClass
	 * @param showPages
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(Class<T> entityClass,int showPages,int pageSize);
}
