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
	
	<%@include file = "header.jsp"%> 
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
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = ""><%=user.getUserName() %></a>:<%=user.getUserRead() %>��</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>��������</h2>
				<ul>
					<%
						users = userDao.findAllUserOrderByApprove();
						i=0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = ""><%=user.getUserName() %></a>:<%=user.getUserApprove() %></div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="hotcomment">
				<h2>��������</h2>
				<ul>
					<%
						CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
						List<Comment> comments = commentDao.findCommentOrderByApprove();
						i = 0;
						for(Comment comment:comments){
					%> 
							<li class = "comment">
								<div><%=comment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=comment.getBookID()%>"><%=comment.getCommentContent() %></a></div>
								<div>������:<%=comment.getCommentApprove() %></div>
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
				<h2>�����ٵ�</h2>
				<ul>
					<%
						BookDao bookDao = BookDaoFactory.getBookDaoInstance();
						List<Book> books = bookDao.findAllBookOrderByTime(); 
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div><a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div><%=book.getBookAurthor() %></div>
							</li>
					<%if(i==1)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="recommendbyhot">
				<h2>���ܹ�ע</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByRead(); 
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div>����:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>����:<%=book.getBookAurthor() %></div>
								<div>�Ѷ�����:<%=book.getBookRead() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="recommendbyscore">
				<h2>�������</h2>
				<ul>
					<%
						books = bookDao.findAllBookOrderByScore();
						i=0;
						for(Book book:books){
					%>
							<li class = "book">
								<div><img src="<%=book.getBookCoverPath()%>"/></div>
								<div>����:<a href = "ShowBook?bookID=<%=book.getBookID()%>"><%=book.getBookName() %></a></div>
								<div>����:<%=book.getBookAurthor() %></div>
								<div>����:<%=book.getBookScore() %></div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	</div>
	
		
</body>
</html>