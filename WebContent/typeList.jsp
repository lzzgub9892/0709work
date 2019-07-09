<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800px" border="1px" align="center">
		<caption>商品类型管理</caption>
		<tr>
			<td>序号</td>
			<td>类型名称</td>
			<td>类型描述</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${typeList }" var="type" varStatus="i">
			<td>${i.index+1 }</td>
			<td>${type.tname }</td>
			<td>${type.tdesc }</td>
			<td><a href="type.do?method=editForm&tid=${type.tid }">编辑</a></td>
			<td><a href="type.do?method=del&tid=${type.tid }">删除</a></td>
		</c:forEach>
	</table>
	<button onclick="location.href='addType.jsp'">添加类型</button>

</body>
</html>