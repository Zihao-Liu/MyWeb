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
	
	<%--@include file = "header.jsp" --%> 
	
	<div id="topnavigation">
		<div id="logo">刘子豪</div>
		
		
		<div id="user">
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<span><font color="red">${requestScope.error }</font></span>
					<form action="StatusRecognise" method="post">
						<span>
							<label for="name" >用户名:</label>
							<input name = "username" type ="text" id = "username">
						</span>
					
						<span>
							<label for="name" >密    码:</label>
							<input name = "userpassword" type = "password" id="password">
						</span>
						<input value = "提交" type = "submit">
						<input value="注册" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
				</c:when>
				<c:otherwise>
					<a href="">用户名：${user.userName}</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="搜索你感兴趣的图书" id ="searchtext">
					<input value="搜索" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">首页</a></li>
					<li class = "navigationbutton"><a href="">图书</a></li>
				</ul>
		</div>
	
	</div>
		
		
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
					<li>liuzihao:200本</li>
					<li>刘子豪:150本</li>
				</ul>
			</div>
			<div class="rank">
				<h2>点赞排名</h2>
				<ul>
				<%
					UserDao userDao = UserDaoFactory.getUserDaoInstance();
					List<User> users = userDao.findAllUserOrderByApprove();
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
					    List<Book> books = bookDao.findAllBookByTime(); 
					    for(Book book:books){
					%>
						<li class = "book">
							<div><img src="<%=book.getBookCoverPath()%>"/></div>
							<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
							<div>作者:<%=book.getBookAurthor() %></div>
						</li>
					<%} %>
				</ul>
			</div>
			
			<div class="recommendbyhot">
				<h2>最受关注</h2>
				<ul>
					<%
						books = bookDao.findAllBookByTime(); 
					    for(Book book:books){
					%>
						<li class = "book">
							<div><img src="<%=book.getBookCoverPath()%>"/></div>
							<div>书名:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
							<div>作者:<%=book.getBookAurthor() %></div>
						</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
		
</body>
</html>