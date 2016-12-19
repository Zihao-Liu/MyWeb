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

<title>��ҳ</title>
</head>
<body>
	
	<%--@include file = "header.jsp" --%> 
	
	<div id="topnavigation">
		<div id="logo">���Ӻ�</div>
		
		
		<div id="user">
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<span><font color="red">${requestScope.error }</font></span>
					<form action="StatusRecognise" method="post">
						<span>
							<label for="name" >�û���:</label>
							<input name = "username" type ="text" id = "username">
						</span>
					
						<span>
							<label for="name" >��    ��:</label>
							<input name = "userpassword" type = "password" id="password">
						</span>
						<input value = "�ύ" type = "submit">
						<input value="ע��" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
				</c:when>
				<c:otherwise>
					<a href="">�û�����${user.userName}</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="���������Ȥ��ͼ��" id ="searchtext">
					<input value="����" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">��ҳ</a></li>
					<li class = "navigationbutton"><a href="">ͼ��</a></li>
				</ul>
		</div>
	
	</div>
		
		
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>����</h2>
				<ul>
					<li><a href="">С˵</a></li>
					<li><a href="">Ϸ��</a></li>
					<li><a href="">ɢ��</a></li>
					<li><a href="">����</a></li>
				</ul>
				<ul>
					<li><a href="">��ʷ</a></li>
					<li><a href="">��ѧ</a></li>
				</ul>	
			</div>
			<div class="rank">
				<h2>�Ķ�����</h2>
				<ul>
					<li>liuzihao:200��</li>
					<li>���Ӻ�:150��</li>
				</ul>
			</div>
			<div class="rank">
				<h2>��������</h2>
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
				<h2>��������</h2>
				<ul>
				<%
					CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
					List<Comment> comments = commentDao.findCommentOrderByApprove();
					for(Comment comment:comments){
				%>
					<li class = "comment">
						<div><%=comment.getCommentTitle() %></div>
						<div><a href = "ShowBook?bookID=<%=comment.getBookID()%>"><%=comment.getCommentContent() %></a></div>
						<div>������:<%=comment.getCommentApprove() %></div>
					</li>
				<%} %>
				</ul>
			</div>
		</div>
	
	
		<div class="main">
			<div class="recommendbytime">
				<h2>�����ٵ�</h2>
				<ul>
					<%
						BookDao bookDao = BookDaoFactory.getBookDaoInstance();
					    List<Book> books = bookDao.findAllBookByTime(); 
					    for(Book book:books){
					%>
						<li class = "book">
							<div><img src="<%=book.getBookCoverPath()%>"/></div>
							<div>����:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
							<div>����:<%=book.getBookAurthor() %></div>
						</li>
					<%} %>
				</ul>
			</div>
			
			<div class="recommendbyhot">
				<h2>���ܹ�ע</h2>
				<ul>
					<%
						books = bookDao.findAllBookByTime(); 
					    for(Book book:books){
					%>
						<li class = "book">
							<div><img src="<%=book.getBookCoverPath()%>"/></div>
							<div>����:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
							<div>����:<%=book.getBookAurthor() %></div>
						</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
		
</body>
</html>