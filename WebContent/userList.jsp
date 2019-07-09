<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserList</title>
</head>
<body>
	<table width="800px" border="1px" align="center">
		<tr>
			<td>用户id</td>
			<td>用户名</td>
			<td>密码</td>		
			<td>编辑</td>
			<td>删除</td>
		</tr>	
		<c:forEach items="${userList }" var="user">
			<tr>
				<td>${user.uid }</td>
				<td>${user.uname }</td>
				<td>${user.upwd }</td>
				<td>
					<a href="user.do?method=editUser&uid=${user.uid }">编辑</a>
				</td>
				<td>
					<a href="user.do?method=delUser&uid=${user.uid }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="addUser.jsp">添加新用户</a>
</body>
</html>