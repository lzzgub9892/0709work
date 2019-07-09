<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="utf-8">
		<title>商品展示</title>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h2 align="center">商品列表</h2>
		<table class="table table-striped">
			
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>类型</th>
				<th>商品图片</th>
				<th>商品价格</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			
			<c:forEach items="${goodsList }" var="goods" varStatus="i">
				<tr>
					<td>${goods.gid }</td>
					<td>${goods.gname }</td>
					<td>
						<c:forEach items="${typeList }" var="type">
							<c:if test="${goods.tid==type.tid }">
								${type.tname }
							</c:if>
						</c:forEach>
					</td>
					<td>
						<img src="images/${goods.gimg }">
					</td>
					<td>${goods.gprice }</td>
					<td><a href="goods.do?method=editForm&gid=${goods.gid }">修改</a></td>
					<td><a href="goods.do?method=del&gid=${goods.gid }">删除</a></td>
				</tr>
			</c:forEach>
			
		</table>
		
		<button type="button" onclick="location.href='goods.do?method=addForm'">增加商品</button>
		
		
	</body>
</html>