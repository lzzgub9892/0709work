package com.woniu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Goods;
import com.woniu.po.Type;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods.do")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		if(method==null){
			findAll(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("del")){
			del(request,response);
		}else if(method.equals("getGoods")){
			editForm(request,response);
		}else if(method.equals("edit")){
			edit(request,response);
		}else if(method.equals("addForm")){
			addForm(request,response);
		}else if(method.equals("editForm")){
			editForm(request,response);
		}
	}
	private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Type> types=DAOFactory.getTypeDAO().findAll();
		request.setAttribute("typeList", types);
		request.getRequestDispatcher("addGoods.jsp").forward(request, response);
	}

	//编辑
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		Goods goods=new Goods();
		Goods oldGoods=null;
		boolean flag=false;
		try {
			List<FileItem> items=upload.parseRequest(request);
			for (FileItem item : items) {
				if(item.isFormField()){
					if("gname".equals(item.getFieldName())){
						goods.setGname(item.getString());
					}else if("gid".equals(item.getFieldName())){
						int gid=Integer.parseInt(item.getString());
						oldGoods=DAOFactory.getGoodsDAO().findOne(gid);
						goods.setGid(gid);
					}else if("tid".equals(item.getFieldName())){
						goods.setTid(Integer.parseInt(item.getString()));
					}else if("gprice".equals(item.getFieldName())){
						goods.setGprice(Double.parseDouble(item.getString()));
					}
				}else{
					String oldName=item.getName();
					if(!oldName.equals("")){
						flag=true;
						String back=oldName.substring(oldName.lastIndexOf("."));
						String path=request.getRealPath("/images");
						String newName=UUID.randomUUID().toString()+back;
						File f=new File(path);
						if(!f.exists()){
							f.mkdirs();
						}
						File f2=new File(f, newName);
						item.write(f2);
						goods.setGimg(newName);
						
						//删除原图片
						File f3=new File(f,oldGoods.getGimg());
						f3.delete();
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!flag){
			goods.setGimg(oldGoods.getGimg());
		}
		DAOFactory.getGoodsDAO().update(goods);
		response.sendRedirect("goods.do");
	}
	
	//获得指定的goods返还给编辑界面
	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int gid=Integer.parseInt(request.getParameter("gid"));
		Goods goods=DAOFactory.getGoodsDAO().findOne(gid);
		request.setAttribute("goods", goods);
		List<Type> types=DAOFactory.getTypeDAO().findAll();
		request.setAttribute("typeList", types);
		request.getRequestDispatcher("goodsEdit.jsp").forward(request, response);
	}

	//删除
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int gid=Integer.parseInt(request.getParameter("gid"));
		Goods goods=DAOFactory.getGoodsDAO().findOne(gid);
		DAOFactory.getGoodsDAO().delete(gid);
		String path=request.getRealPath("/images");
		File f=new File(path);
		File f2=new File(f, goods.getGimg());
		f2.delete();
		response.sendRedirect("goods.do");
		
	}

	//新增
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		Goods goods=new Goods();
		try {
			List<FileItem> items=upload.parseRequest(request);
			for (FileItem item : items) {
				if(item.isFormField()){
					if("gname".equals(item.getFieldName())){
						goods.setGname(item.getString());
					}else if("tid".equals(item.getFieldName())){
						goods.setTid(Integer.parseInt(item.getString()));
					}else if("gprice".equals(item.getFieldName())){
						goods.setGprice(Double.parseDouble(item.getString()));
					}
				}else{
					String oldName=item.getName();
					if(!oldName.equals("")){
						String back=oldName.substring(oldName.lastIndexOf("."));
						String path=request.getRealPath("/images");
						String newName=UUID.randomUUID().toString()+back;
						File f=new File(path);
						if(!f.exists()){
							f.mkdirs();
						}
						File f2=new File(f, newName);
						item.write(f2);
						goods.setGimg(newName);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOFactory.getGoodsDAO().save(goods);
		response.sendRedirect("goods.do");
	}

	//获得所有
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Goods> goods=DAOFactory.getGoodsDAO().findAll();
		List<Type> types=DAOFactory.getTypeDAO().findAll();
		request.setAttribute("typeList", types);
		request.setAttribute("goodsList", goods);
		request.getRequestDispatcher("goodsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
