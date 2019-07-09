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
	<form action="type.do?method=add" method="post">
	类型名称:<input type="text" name="tname"><br/>
	类型描述:<input type="text" name="tdesc"><br/>
	<button type="reset">重置</button>
	<button type="submit">新增</button>
	</form>

</body>
</html>