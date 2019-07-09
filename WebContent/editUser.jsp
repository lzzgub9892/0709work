<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="user.do?method=edit" method="post" >
	<input type="hidden" name="uid" value="${user.uid }">
		用户名<input type="text" name="uname" value="${user.uname }" /><br />	
		密&nbsp;&nbsp;&nbsp;码
		<input type="password" name="upwd" value="${user.upwd }"/><br>
		<p>
			<button>OJBK</button>
		</p>
	
	
	</form>
</body>
</html>