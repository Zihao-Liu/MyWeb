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
<link href="bookpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<title>图书</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("小说", "utf-8") %>">小说</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("戏剧", "utf-8") %>">戏剧</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("散文", "utf-8") %>">散文</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("漫画", "utf-8") %>">漫画</a></li>
				</ul>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("历史", "utf-8") %>">历史</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("哲学", "utf-8") %>">哲学</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>阅读排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserRead() %>本</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>点赞排名</h2>
				<ul>
					<%
						users = userDao.findAllUserOrderByApprove();
						i=0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserApprove() %></div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="hotcomment">
				<h2>热门评论</h2>
				<ul>
					<%
						BookCommentDao bookCommentDao = BookCommentDaoFactory.getCommentDaoInstance();
						List<BookComment> bookComments = bookCommentDao.findCommentOrderByApprove();
						i = 0;
						for(BookComment bookComment:bookComments){
					%> 
							<li class = "comment">
								<div><%=bookComment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=bookComment.getBookID()%>"><%=bookComment.getCommentContent() %></a></div>
								<div>点赞数:<%=bookComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	
	
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
								<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>作者:<%=book.getBookAuthor() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %> 
				</ul>
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
								<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>作者:<%=book.getBookAuthor() %></div>
								<div>已读人数:<%=book.getBookRead() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
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
								<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>作者:<%=book.getBookAuthor() %></div>
								<div>评分:<%=book.getBookScore() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>