<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>ע��</title>
</head>
<body>
<%@include file = "header.jsp" %> 
<%-- <div id="topnavigation">
		<div id="logo">���Ӻ�</div>
		
		
		<div id="user">
			
		</div>
		
		<div id="menu">
				<form action="SearchBook" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="���������Ȥ��ͼ������" id ="searchtext">
					<input value="����" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">��ҳ</a></li>
					<li class = "navigationbutton"><a href="">ͼ��</a></li>
				</ul>
		</div>
	
	</div>--%>

	<font color="red">${requestScope.error }</font>
	<br><br>
	<form action="Register" method="post">
		�û���:<input name = "username" type = "text">
		����:<input name = "userpassword" type = "password">
		�Ա�:<input name = "usersex"  value = "man" type = "radio" >��
			   <input name = "usersex"  value = "woman" type = "radio" >Ů
		<input value = "�ύ" type = "submit">
	</form>
	
	<%@include file = "footer.jsp"%>
</body>
</html>