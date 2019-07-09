package com.woniu.dao.impl;

import java.util.List;

import com.woniu.dao.BaseDAO;
import com.woniu.dao.IUserDAO;
import com.woniu.po.User;



public class UserDAOImpl implements IUserDAO{
	BaseDAO<User> bd=new BaseDAO<User>();
	//��
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,?,?)";
		Object[] objs={user.getUname(),user.getUpwd()};
		bd.update(sql, objs);
	}
	//�޸�
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql="update user set uname=?,upwd=? where uid=?";
		Object[] objs={user.getUname(),user.getUpwd(),user.getUid()};
		bd.update(sql, objs);
	}
	//����uidɾ��һ��
	@Override
	public void delete(int uid) {
		// TODO Auto-generated method stub
		String sql="delete from user where uid=?";
		Object[] objs={uid};
		bd.update(sql, objs);
	}
	//����uid��һ��
	@Override
	public User findOne(int uid) {
		// TODO Auto-generated method stub
		String sql="select*from user where uid=?";
		Object[] objs={uid};
		List<User> list=bd.select(sql, objs, User.class);
		return list.size()==0?null:list.get(0);
	}
	//������
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql="select*from user";
		Object[] objs={};
		List<User> list=bd.select(sql, objs, User.class);
		return list;
	}
	
}
