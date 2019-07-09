package com.woniu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Type;

/**
 * Servlet implementation class TypeServlet
 */
@WebServlet("/type.do")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method==null){
			findAll(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("del")){
			del(request,response);
		}else if(method.equals("editForm")){
			editForm(request,response);
		}else if(method.equals("edit")){
			edit(request,response);
		}
	}
   //修改
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(request.getParameter("tid"));
		String tname=request.getParameter("tname");
		String tdesc=request.getParameter("tdesc");
		Type type=new Type(tid, tname, tdesc);
		DAOFactory.getTypeDAO().update(type);
		response.sendRedirect("type.do");
	}

	//获得要被修改的type，返还给修改界面
	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(request.getParameter("tid"));
		Type type =DAOFactory.getTypeDAO().findOne(tid);
		request.setAttribute("type", type);
		request.getRequestDispatcher("editType.jsp").forward(request, response);
	}

	//删除
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int tid=Integer.parseInt(request.getParameter("tid"));
		DAOFactory.getTypeDAO().delete(tid);
		response.sendRedirect("type.do");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String tname=request.getParameter("tname");
		String tdesc=request.getParameter("tdesc");
		Type type=new Type();
		type.setTname(tname);
		type.setTdesc(tdesc);
		DAOFactory.getTypeDAO().save(type);
		response.sendRedirect("type.do");
	}

	//展现所有
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Type> types=DAOFactory.getTypeDAO().findAll();
		request.setAttribute("typeList", types);
		request.getRequestDispatcher("typeList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
