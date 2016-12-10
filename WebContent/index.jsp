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
<title>��ҳ</title>
</head>
<body>
	<%--<div id="topexplain">���Ӻ�</div>
	<div id="search">
		<form action="" method="post">
			<input name="searchText" type="text">
			<input value="����" type="submit">
		</form>
	</div>
	<div id="menu">
		<ul>
			<li id="book"><a href="">ͼ��</a></li>
		</ul>
	</div>--%>
	<%@include file = "header.jsp" %> 
	
	<div id="user">
		<h1>�û���Ϣ</h1>
		<c:choose>
		<c:when test="${empty sessionScope.user}">
			<font color="red">${requestScope.error }</font>
			<form action="StatusRecognise" method="post">
			�û���:<input name = "username" type ="text" >
			����:<input name = "userpassword" type = "password">
			<input value = "�ύ" type = "submit">
			<input value="ע��"type = "button" style = "width:45px;" onclick = "window.location.href='register.jsp';">
			</form>
		</c:when>
		<c:otherwise>
			<ul>
			  <li>�û�����${user.userName}</li>
			  <li>��     ��${user.userSex}</li>
			  <li>������: ${user.userApprove }</li>
			</ul>
		</c:otherwise>
	</c:choose>
		<%--
			Object obj = session.getAttribute("user");
			if(obj == null){
		--%>
		<%-- <font color="red">${requestScope.error }</font>
		<form action="StatusRecognise" method="post">
		�û���:<input name = "username" type ="text" >
		����:<input name = "userpassword" type = "password">
		<input value = "�ύ" type = "submit">
		<input value="ע��"type = "button" style = "width:45px;" onclick = "window.location.href='register.jsp';">
		</form>
		<%}else{%>
		<ul>
			<li>�û���:${user.userName}</li>
			<li>�Ա�:${user.userSex}</li>
		</ul>
		<%} --%>
	</div>
	<div id="bookrecommend">
		<h1>ͼ����Ϣ</h1>
		<%
			BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		    List<Book> books = bookDao.findAllBook(); 
		    for(Book book:books){
		%>
			<ul>
				<li>����:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></li>
				<li>����:<%=book.getBookAurthor() %></li>
				<li>����:<%=book.getBookType() %></li>
				<li>���:<%=book.getBookInfo() %></li>
			</ul>
		<%} %>
		
	</div>
	<c:if test="${not empty sessionScope.user}">
		<div id="addbook">
			<a href = "./addBook.jsp">����ͼ��</a>
		</div>
	</c:if>
</body>
</html>