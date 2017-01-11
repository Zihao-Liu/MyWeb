<%@page import="daoImpl.BookDaoImpl" language="java"%>
<%@page import="factory.BookDaoFactory" language="java"%>
<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.BookCommentDaoFactory" language="java"%>
<%@page import="dao.BookDao" language="java"%>
<%@page import="dao.BookCommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="bean.Book" language="java"%>
<%@page import="bean.BookComment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/bookpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>已读图书</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<%@include file = "bookSideBar.jsp"%>
	
	
		<div class="main">
			<div class="allbook">
				<h2>他的书单</h2>		
				<c:forEach items="${requestScope.userreadbook}" var="userreadbook" >
					<li class = "book">
						<div><img src="${userreadbook.bookCoverPath}"/></div>
						<div><a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
						<div>${userreadbook.bookAuthor}</div>
					</li>
				</c:forEach>
			</div>
			
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>