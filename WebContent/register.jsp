<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>注册</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="Register" method="post">
		用户名:<input name = "username" type = "text">
		密码:<input name = "userpassword" type = "password">
		性别:<input name = "usersex"  value = "man" type = "radio" >男
			   <input name = "usersex"  value = "woman" type = "radio" >女
		<input value = "提交" type = "submit">
	</form>
</body>
</html>