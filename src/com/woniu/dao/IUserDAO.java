package com.woniu.dao;

import java.util.List;

import com.woniu.po.User;

public interface IUserDAO {
	void save(User user);
	void update(User user);
	void delete(int uid);
	User findOne(int uid);
	List<User> findAll();
}
