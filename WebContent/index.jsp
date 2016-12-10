<%@page import="daoImpl.BookDaoImpl"%>
<%@page import="factory.BookDaoFactory"%>
<%@page import="factory.UserDaoFactory"%>
<%@page import="dao.BookDao"%>
<%@page import="bean.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>主页</title>
</head>
<body>
	<%--<div id="topexplain">刘子豪</div>
	<div id="search">
		<form action="" method="post">
			<input name="searchText" type="text">
			<input value="搜索" type="submit">
		</form>
	</div>
	<div id="menu">
		<ul>
			<li id="book"><a href="">图书</a></li>
		</ul>
	</div>--%>
	<%@include file = "header.jsp" %> 
	
	<div id="user">
		<h1>用户信息</h1>
		<c:choose>
		<c:when test="${empty sessionScope.user}">
			<font color="red">${requestScope.error }</font>
			<form action="StatusRecognise" method="post">
			用户名:<input name = "username" type ="text" >
			密码:<input name = "userpassword" type = "password">
			<input value = "提交" type = "submit">
			<input value="注册"type = "button" style = "width:45px;" onclick = "window.location.href='register.jsp';">
			</form>
		</c:when>
		<c:otherwise>
			<ul>
			  <li>用户名：${user.userName}</li>
			  <li>性     别：${user.userSex}</li>
			  <li>点赞数: ${user.userApprove }</li>
			</ul>
		</c:otherwise>
	</c:choose>
		<%--
			Object obj = session.getAttribute("user");
			if(obj == null){
		--%>
		<%-- <font color="red">${requestScope.error }</font>
		<form action="StatusRecognise" method="post">
		用户名:<input name = "username" type ="text" >
		密码:<input name = "userpassword" type = "password">
		<input value = "提交" type = "submit">
		<input value="注册"type = "button" style = "width:45px;" onclick = "window.location.href='register.jsp';">
		</form>
		<%}else{%>
		<ul>
			<li>用户名:${user.userName}</li>
			<li>性别:${user.userSex}</li>
		</ul>
		<%} --%>
	</div>
	<div id="bookrecommend">
		<h1>图书信息</h1>
		<%
			BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		    List<Book> books = bookDao.findAllBook(); 
		    for(Book book:books){
		%>
			<ul>
				<li>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></li>
				<li>作者:<%=book.getBookAurthor() %></li>
				<li>分类:<%=book.getBookType() %></li>
				<li>简介:<%=book.getBookInfo() %></li>
			</ul>
		<%} %>
		
	</div>
	<c:if test="${not empty sessionScope.user}">
		<div id="addbook">
			<a href = "./addBook.jsp">新增图书</a>
		</div>
	</c:if>
</body>
</html>