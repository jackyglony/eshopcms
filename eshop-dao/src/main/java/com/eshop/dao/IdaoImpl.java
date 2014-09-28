package com.eshop.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.eshop.commons.Pager;

@Service
public class IdaoImpl<T,PK extends Serializable> extends SqlSessionDaoSupport implements Idao<T, Serializable>{
	
	public void save(T entity) {
		getSqlSession().insert(entity.getClass().getName()+".add", entity);
	}
	
	
	public void delete(Class<T> entityClass, Serializable pk) {
		getSqlSession().delete(entityClass.getName()+".delete", pk);
	}

	public void update(T entity) {
		getSqlSession().update(entity.getClass().getName(),entity);
	}

	
	public T findById(Class<T> entityClass, Serializable pk) {
		return getSqlSession().selectOne(entityClass.getName()+".findById", pk);
	}

	
	public List<T> findAll(Class<T> entityClass) {
		return getSqlSession().selectList(entityClass.getName()+".findAll");
	}

	
	 public Pager<T> findByPage(Class<T> entityClass,int showPages,int pageSize) {
		 Pager<T> pager = new Pager<T>();
		 Map<String, Object> maps = new HashMap<String, Object>();
		 maps.put("showPages", showPages);
		 maps.put("pageSize", pageSize);
		 List<T> pageList = getSqlSession().selectList(entityClass.getName()+".findByPage", maps);
		 int total = getSqlSession().selectOne(entityClass.getName()+".findTotal");
		 pager.setPageList(pageList);
		 pager.setTotal(total);
		 return pager;
	 }

}
