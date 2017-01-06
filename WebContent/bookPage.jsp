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
<title>图书</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<%@include file = "bookSideBar.jsp"%> 
	
	
		<div class="main">
			<div class="recommendbytime">
				<h2>新书速递</h2>
				<ul>
					<%
						BookDao bookDao = BookDaoFactory.getBookDaoInstance();
						List<Book> books = bookDao.findAllBookOrderByTime(); 
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><img src="<%=book.getBookCoverPath()%>"/></a></div>
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div><%=book.getBookAuthor() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %> 
				</ul>
				<a href = "./showAllBook.jsp">显示所有>></a>
			</div>
			
			<div class="recommendbyhot">
				<h2>最受关注</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByRead(); 
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><img src="<%=book.getBookCoverPath()%>"/></a></div>
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div><%=book.getBookAuthor() %></div>
								<div>已读人数:<%=book.getBookRead() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
				<a href = "./showAllBook.jsp">显示所有>></a>
			</div>
		
			<div class="recommendbyscore">
				<h2>评分最高</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByScore();
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><img src="<%=book.getBookCoverPath()%>"/></a></div>
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div><%=book.getBookAuthor() %></div>
								<div>评分:<%=book.getBookScore() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
				<a href = "./showAllBook.jsp">显示所有>></a>
			</div>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>