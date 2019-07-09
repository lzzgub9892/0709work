package com.woniu.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniu.util.JdbcUtil;



public class BaseDAO<T> {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	/**
	 * �������е���ɾ��sql
	 * @param sql
	 * @param objs
	 */
	public void update(String sql,Object[] objs){
		try {
			conn=JdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			int row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn, ps, rs);
		}
		
	}
	
	public List<T> select(String sql,Object[] objs,Class c){
		List<T> list=new ArrayList<T>();
		try {
			conn=JdbcUtil.getConn();
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			rs=ps.executeQuery();
			while(rs.next()){
				//ʵ��������
				Object obj=c.newInstance();
				//��ȡClass��������з���
				Method[] ms=c.getDeclaredMethods();
				for(Method m:ms){
					String methodName=m.getName();
					//�ҳ����е�set����
					if (methodName.startsWith("set")) {
						String fieldName=methodName.substring(3);
						//���set�����Ĳ�������
						Class[] cs=m.getParameterTypes();
						//ѡ����ʵ��������÷���ִ��set����
						if (cs[0]==int.class) {
							m.invoke(obj, rs.getInt(fieldName));
						}else if (cs[0]==int.class) {
							m.invoke(obj, rs.getInt(fieldName));
						}else if (cs[0]==String.class) {
							m.invoke(obj, rs.getString(fieldName));
						}else if (cs[0]==double.class) {
							m.invoke(obj, rs.getDouble(fieldName));
						}else if (cs[0]==Date.class) {
							m.invoke(obj, rs.getDate(fieldName));
						}
					}
				}
				//�Ѷ�����ӵ�������
				list.add((T) obj);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConn(conn, ps, rs);
		}
		
		return list;
	}
}
