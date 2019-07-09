package com.woniu.dao.impl;

import com.woniu.dao.BaseDAO;
import com.woniu.dao.IGoodsDAO;
import com.woniu.po.Goods;

import java.util.List;




public class GoodsDAOImpl implements IGoodsDAO{
	BaseDAO<Goods> bd=new BaseDAO<Goods>();
	//��
	@Override
	public void save(Goods goods) {
		// TODO Auto-generated method stub
		String sql="insert into goods values(null,?,?,?,?)";
		Object[] objs={goods.getGname(),goods.getTid(),goods.getGimg(),goods.getGprice()};
		bd.update(sql, objs);
	}
	//�޸�
	@Override
	public void update(Goods goods) {
		// TODO Auto-generated method stub
		String sql="update goods set gname=?,tid=?,gimg=?,gprice=? where gid=?";
		Object[] objs={goods.getGname(),goods.getTid(),goods.getGimg(),goods.getGprice(),goods.getGid()};
		bd.update(sql, objs);
	}
	//����gidɾ��һ��
	@Override
	public void delete(int gid) {
		// TODO Auto-generated method stub
		String sql="delete from goods where gid=?";
		Object[] objs={gid};
		bd.update(sql, objs);
	}
	//����gid��һ��
	@Override
	public Goods findOne(int gid) {
		// TODO Auto-generated method stub
		String sql="select*from goods where gid=?";
		Object[] objs={gid};
		List<Goods> list=bd.select(sql, objs, Goods.class);
		return list.size()==0?null:list.get(0);
	}
	//������
	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		String sql="select*from goods";
		Object[] objs={};
		List<Goods> list=bd.select(sql, objs, Goods.class);
		return list;
	}

}
