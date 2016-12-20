<%@page import="daoImpl.BookDaoImpl"%>
<%@page import="factory.BookDaoFactory"%>
<%@page import="factory.UserDaoFactory"%>
<%@page import="factory.CommentDaoFactory"%>
<%@page import="dao.BookDao"%>
<%@page import="dao.CommentDao"%>
<%@page import="dao.UserDao"%>
<%@page import="bean.Book"%>
<%@page import="bean.Comment"%>
<%@page import="bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="index.css" type="text/css" rel="stylesheet" media="all" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />

<title>主页</title>
</head>
<body>
	
	<%@include file = "header.jsp"%> 
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
				<ul>
					<li><a href="">小说</a></li>
					<li><a href="">戏剧</a></li>
					<li><a href="">散文</a></li>
					<li><a href="">漫画</a></li>
				</ul>
				<ul>
					<li><a href="">历史</a></li>
					<li><a href="">哲学</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>阅读排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = ""><%=user.getUserName() %></a>:<%=user.getUserRead() %>本</div>
							</li>
					<%} %>
				</ul>
			</div>
			
			<div class="rank">
				<h2>点赞排名</h2>
				<ul>
					<%
						users = userDao.findAllUserOrderByApprove();
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = ""><%=user.getUserName() %></a>:<%=user.getUserApprove() %></div>
							</li>
					<%} %>
				</ul>
			</div>
		
			<div class="hotcomment">
				<h2>热门评论</h2>
				<ul>
					<%
						CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
						List<Comment> comments = commentDao.findCommentOrderByApprove();
						for(Comment comment:comments){
					%>
							<li class = "comment">
								<div><%=comment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=comment.getBookID()%>"><%=comment.getCommentContent() %></a></div>
								<div>点赞数:<%=comment.getCommentApprove() %></div>
							</li>
					<%} %>
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
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div><%=book.getBookAurthor() %></div>
							</li>
					<%} %>
				</ul>
			</div>
			
			<div class="recommendbyhot">
				<h2>最受关注</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByRead(); 
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>作者:<%=book.getBookAurthor() %></div>
								<div>已读人数:<%=book.getBookRead() %></div>
							</li>
					<%} %>
				</ul>
			</div>
		
			<div class="recommendbyscore">
				<h2>评分最高</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByScore(); 
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>作者:<%=book.getBookAurthor() %></div>
								<div>评分:<%=book.getBookScore() %></div>
							</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
	
		
</body>
</html>