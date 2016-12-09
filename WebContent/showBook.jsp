<%@page import="factory.UserDaoFactory"%>
<%@page import="factory.CommentDaoFactory"%>
<%@page import="bean.Book"%>
<%@page import="bean.Comment"%>
<%@page import="dao.CommentDao"%>
<%@page import="dao.BookDao"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>图书信息</title>
</head>
<body>
	<h1>${book.bookName}</h1>
	<h1>${book.bookAurthor}</h1>
	<h1>${book.bookType}</h1>
	<h1>${book.bookInfo}</h1>
	<br><br>
	
	
	<h2>评论区</h2>
	
	<c:forEach items="${requestScope.commentList}" var="comment">
		<div>
			${comment.commentContent}
			<div align="right">回复人ID：${comment.userID} 
	  			回复时间：${comment.publishTime}</div>
	  		<hr/>
		</div>
	</c:forEach>
	
	<h2>评论区2</h2>
	<%
		CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
		List<Comment> comments = (List<Comment>)request.getAttribute("commentList");
		for(Comment comment:comments){
	%>
		<%=comment.getCommentContent() %>
	<%} %>
	
	<div class="commentBox">
		<font color="red">${requestScope.error }</font>
		<form action="AddComment" method="post">
			<p>标题:<input name = "commenttitle" type = "text"></p>
			<p>内容</p>
			<p>
				<FCK:editor instanceName="commentcontent" basePath="/fckeditor" toolbarSet="myToolbar" height="400" width="750"></FCK:editor>
			</p>
			<input type="hidden" name="bookID" value="${book.bookID}"/> 
			<p><input value = "提交" type = "submit"></p>
		</form>
	
	</div>
</body>
</html>