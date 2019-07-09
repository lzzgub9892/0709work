package com.woniu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;
import com.woniu.dao.DAOFactory;
import com.woniu.po.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method == null || method.equals("userList")) {
			findAll(request, response);
		} else if (method.equals("addUser")) {
			addUser(request, response);
		} else if (method.equals("delUser")) {
			delUser(request, response);
		}else if(method.equals("editUser")){
			getUserById(request,response);
		}else if(method.equals("edit")){
			editUser(request,response);
		}
	}
	//修改用户信息
	private void editUser(HttpServletRequest request,HttpServletResponse response){
		User user=new User();
		int uid = Integer.parseInt(request.getParameter("uid"));
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		user.setUid(uid);
		user.setUname(uname);
		user.setUpwd(upwd);
		DAOFactory.getUserDAO().update(user);
		try {
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查询指定用户
	private void getUserById(HttpServletRequest request,HttpServletResponse response){
		int uid=Integer.parseInt(request.getParameter("uid"));
		User user=DAOFactory.getUserDAO().findOne(uid);
		request.setAttribute("user",user);
		try {
			request.getRequestDispatcher("editUser.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//删除指定用户
	private void delUser(HttpServletRequest request, HttpServletResponse response) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		DAOFactory.getUserDAO().delete(uid);
		try {
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加用户
	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		user.setUname(uname);
		user.setUpwd(upwd);
		DAOFactory.getUserDAO().save(user);
		try {
			response.sendRedirect("user.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查询所有用户
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<User> userList = DAOFactory.getUserDAO().findAll();
		request.setAttribute("userList", userList);
		try {
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
