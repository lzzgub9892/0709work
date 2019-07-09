package com.woniu.dao;

import com.woniu.dao.impl.GoodsDAOImpl;
import com.woniu.dao.impl.TypeDAOImpl;
import com.woniu.dao.impl.UserDAOImpl;

public class DAOFactory {
	public static IUserDAO getUserDAO(){
		return new UserDAOImpl();
	}
	public static ITypeDAO getTypeDAO(){
		return new TypeDAOImpl();
	}
	public static IGoodsDAO getGoodsDAO(){
		return new GoodsDAOImpl();
	}
}
