<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>ע��</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="Register" method="post">
		�û���:<input name = "username" type = "text">
		����:<input name = "userpassword" type = "password">
		�Ա�:<input name = "usersex"  value = "man" type = "radio" >��
			   <input name = "usersex"  value = "woman" type = "radio" >Ů
		<input value = "�ύ" type = "submit">
	</form>
</body>
</html>