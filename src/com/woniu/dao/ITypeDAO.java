package com.woniu.dao;

import java.util.List;

import com.woniu.po.Type;

public interface ITypeDAO {
	void save(Type type);
	void update(Type type);
	void delete(int tid);
	Type findOne(int tid);
	List<Type> findAll();
}
