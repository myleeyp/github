package com.qfedu.hrs.persistence;

import java.io.Serializable;
import java.util.List;

// DAO = Data Access Object
// Data Accessor - 封装CRUD方法
// Active Domain Object - 用对象组织数据

public interface BaseDAO <E, K extends Serializable> {

	void save(E entity);
	
	boolean deleteById(K id);
	
	void delete(E entity);
	
	void upate(E entity);
	
	List<E> findAll();
	
	E findById(K id);
}
