<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>注册</title>
</head>
<body>
<%@include file = "header.jsp" %> 
<%-- <div id="topnavigation">
		<div id="logo">刘子豪</div>
		
		
		<div id="user">
			
		</div>
		
		<div id="menu">
				<form action="SearchBook" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="搜索你感兴趣的图书名称" id ="searchtext">
					<input value="搜索" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">首页</a></li>
					<li class = "navigationbutton"><a href="">图书</a></li>
				</ul>
		</div>
	
	</div>--%>

	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="Register" method="post">
		用户名:<input name = "username" type = "text">
		密码:<input name = "userpassword" type = "password">
		性别:<input name = "usersex"  value = "man" type = "radio" >男
			   <input name = "usersex"  value = "woman" type = "radio" >女
		<input value = "提交" type = "submit">
	</form>
	
	<%@include file = "footer.jsp"%>
</body>
</html>