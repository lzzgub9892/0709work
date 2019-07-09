<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<meta charset="utf-8">
		<title>商品修改</title>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h2 align="center">修改商品</h2>
		<div class="col-md-10">
		<form class="form-horizontal" action="goods.do?method=edit" role="form" method="post" enctype="multipart/form-data">
		<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">商品名称</label>
		<div class="col-sm-10">
		<input type="hidden" class="form-control" name="gid" value="${goods.gid }" >
			<input type="text" class="form-control" name="gname" 
				   value="${goods.gname }">
		</div>
		
		
		
		<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">商品类型</label>
		<div class="col-sm-10">
			<select name="tid">
			<c:forEach items="${typeList }" var="type">
				<option value="${type.tid }">${type.tname }</option>
			</c:forEach>	
			</select>
		</div>
		
		
		
		
		</div>
		<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">商品图片</label>
		<div class="col-sm-10">
			<img src="images/${goods.gimg }"><br>
			<input type="file" class="form-control" name="gimg" >
		</div>
		</div>
		
		<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">商品价格</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="gprice" 
				   value="${goods.gprice }">
		</div>
		</div>
		
		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">提交</button>
		</div>
		</div>
	</form>
		</div>
		
		
	</body>
</html>