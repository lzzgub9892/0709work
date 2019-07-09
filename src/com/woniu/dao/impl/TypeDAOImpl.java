package com.woniu.dao.impl;

import java.util.List;

import com.woniu.dao.BaseDAO;
import com.woniu.dao.ITypeDAO;
import com.woniu.po.Type;
import com.woniu.po.User;
public class TypeDAOImpl implements ITypeDAO{
	BaseDAO<Type> bd=new BaseDAO<Type>();
	//��
	@Override
	public void save(Type type) {
		// TODO Auto-generated method stub
		String sql="insert into type values(null,?,?)";
		Object[] objs={type.getTname(),type.getTdesc()};
		bd.update(sql, objs);
	}
	//�޸�
	@Override
	public void update(Type type) {
		// TODO Auto-generated method stub
		String sql="update type set tname=?,tdesc=? where tid=?";
		Object[] objs={type.getTname(),type.getTdesc(),type.getTid()};
		bd.update(sql, objs);
	}
	//����tidɾ��һ��
	@Override
	public void delete(int tid) {
		// TODO Auto-generated method stub
		String sql="delete from type where tid=?";
		Object[] objs={tid};
		bd.update(sql, objs);
	}
	//����uid��һ��
	@Override
	public Type findOne(int tid) {
		// TODO Auto-generated method stub
		String sql="select*from type where tid=?";
		Object[] objs={tid};
		List<Type> list=bd.select(sql, objs, Type.class);
		return list.size()==0?null:list.get(0);
	}
	//������
	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		String sql="select*from type";
		Object[] objs={};
		List<Type> list=bd.select(sql, objs, Type.class);
		return list;
	}

}
