<%@page import="factory.ReadDaoFactory"%>
<%@page import="dao.ReadDao"%>
<%@page import="factory.BookApproveDaoFactory"%>
<%@page import="factory.UserDaoFactory"%>
<%@page import="factory.BookCommentDaoFactory"%>
<%@page import="bean.Book"%>
<%@page import="bean.User"%>
<%@page import="bean.BookComment"%>
<%@page import="dao.BookCommentDao"%>
<%@page import="dao.BookDao"%>
<%@page import="dao.UserDao"%>
<%@page import="dao.BookApproveDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/showbook.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>图书信息</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<div class = "bookInfo">
		<h2>${book.bookName}</h2>
		<div class="Infodisplay" >
			<img src="${book.bookCoverPath }">
			<ul>
				<li>作者:${book.bookAuthor}</li>
				<li>分类:${book.bookType}</li>
				<li>阅读人数:${book.bookRead }</li>
				<li>评分:${book.bookScore }</li>
			</ul>
		</div>
		
		
		<%
			Book book = (Book)request.getAttribute("book");
			User user = (User)session.getAttribute("user");
			if(user==null){
		%>
		<form action="ModifyReadNum" method="post" class="read">
			<label><input name="score" type="radio" value="1" />1分</label>
			<label><input name="score" type="radio" value="2" />2分</label>
			<label><input name="score" type="radio" value="3" />3分</label>
			<label><input name="score" type="radio" value="4" />4分</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5分</label>
			<input type="submit" value="读过"/>
			<input type="hidden" value ="${book.bookID}" name = "bookID"/>
		</form>
	<%}else{
			ReadDao readDao = ReadDaoFactory.getReadDAoInstance();
			int bookID = book.getBookID();
			int userID = user.getUserID();
			if(readDao.findRead(bookID, userID)==null){
	%>
		<form action="ModifyReadNum" method="post" class="read">
			<label><input name="score" type="radio" value="1" />1分</label>
			<label><input name="score" type="radio" value="2" />2分</label>
			<label><input name="score" type="radio" value="3" />3分</label>
			<label><input name="score" type="radio" value="4" />4分</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5分</label>
			<input type="submit" value="读过"/>
			<input type="hidden" value ="${book.bookID}" name = "bookID"/>
		</form>
	<%} else{%><font color="red">${requestScope.error }</font>
	<label class = "read">您的评分:<%=readDao.findRead(bookID, userID).getScore() %></label>
	<%} }%>
		<h2>内容简介:</h2>
		<p class="brief">${book.bookInfo}</p>
	</div>
	
	

	<div class="comment">
		<h2>热门评论</h2>
		<c:forEach items="${requestScope.commentList1}" var="comment">
			<div class="commentInfo">
				${comment.commentTitle }:
				${comment.commentContent}
				<div class="commentuserInfo">
					回复人:${comment.userID} 
			  		时间:${comment.publishTime}
			  		<font color="red">${requestScope.error1 }</font>
			  		<a href="ModifyBookApproveNum?commentID=${comment.commentID}&action=1">赞同</a>
			  		${comment.commentApprove}
			  		<a href="ModifyBookApproveNum?commentID=${comment.commentID}&action=0">反对</a>
			  	</div>
		  	</div>
		</c:forEach>
		
		<h2>最新评论</h2>
		<c:forEach items="${requestScope.commentList2}" var="comment">
			<div class="commentInfo">
				${comment.commentTitle }:
				${comment.commentContent}
			</div>
			<div class="commentuserInfo">
				回复人:${comment.userID} 
		  		时间:${comment.publishTime}
		  		<font color="red">${requestScope.error1 }</font>
		  		<a href="ModifyBookApproveNum?commentID=${comment.commentID}&action=1">赞同</a>
		  		${comment.commentApprove}
		  		<a href="ModifyBookApproveNum?commentID=${comment.commentID}&action=0">反对</a>
		  	</div>
		</c:forEach>
		
		
		
		
		<%-- <div class="commentBox">
			<form action="AddBookComment" method="post">
				<p>标题:<input name = "commenttitle" type = "text"></p>
				<p>内容:</p>
				<p>
					<FCK:editor instanceName="commentcontent" basePath="/fckeditor" toolbarSet="myToolbar" height="400" width="750"></FCK:editor>
				</p>
				<input type="hidden" name="bookID" value="${book.bookID}"/> 
				<p><input value = "提交" type = "submit"></p>
			</form>
		
		</div>--%>
		
		<div class="commentBox">
			<form action="AddBookComment" method="post">
				<p>标题:<input name = "commenttitle" type = "text"></p>
				<p>内容:</p>
				
					<textarea cols="80" rows="10" name="commentcontent">你有什么想说的</textarea>
					<script type="text/javascript">CKEDITOR.replace( "commentcontent",{
						width:950,height:300,
						toolbar :'basic'});
					</script>
				<input type="hidden" name="bookID" value="${book.bookID}"/> 
				<p><input value = "提交" type = "submit"></p>
			</form>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>