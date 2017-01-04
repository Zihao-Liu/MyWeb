<%@page import="factory.WatchDaoFactory"%>
<%@page import="dao.WatchDao"%>
<%@page import="factory.FilmApproveDaoFactory"%>
<%@page import="factory.UserDaoFactory"%>
<%@page import="factory.FilmCommentDaoFactory"%>
<%@page import="bean.Film"%>
<%@page import="bean.User"%>
<%@page import="bean.FilmComment"%>
<%@page import="dao.FilmCommentDao"%>
<%@page import="dao.FilmDao"%>
<%@page import="dao.UserDao"%>
<%@page import="dao.FilmApproveDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<link href="showfilm.css" type="text/css" rel="stylesheet" media="all" />
<title>��Ӱ��Ϣ</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<div class = "filmInfo">
		<h2>${film.filmName}</h2>
		<div class="Infodisplay" >
			<img src="${film.filmCoverPath }">
			<ul>
				<li>����:${film.filmDirector}</li>
				<li>����:${film.filmType}</li>
				<li>�ۿ�����:${film.filmWatch }</li>
				<li>����:${film.filmScore }</li>
			</ul>
		</div>
		
		
		<%
			Film film = (Film)request.getAttribute("film");
			User user = (User)session.getAttribute("user");
			if(user==null){
		%>
		<form action="ModifyWatchNum" method="post" class="watch">
			<label><input name="score" type="radio" value="1" />1��</label>
			<label><input name="score" type="radio" value="2" />2��</label>
			<label><input name="score" type="radio" value="3" />3��</label>
			<label><input name="score" type="radio" value="4" />4��</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5��</label>
			<input type="submit" value="����"/>
			<input type="hidden" value ="${film.filmID}" name = "filmID"/>
		</form>
	<%}else{
			WatchDao watchDao = WatchDaoFactory.getWatchDAoInstance();
			int filmID = film.getFilmID();
			int userID = user.getUserID();
			if(watchDao.findWatch(filmID, userID)==null){
	%>
		<form action="ModifyWatchNum" method="post" class="watch">
			<label><input name="score" type="radio" value="1" />1��</label>
			<label><input name="score" type="radio" value="2" />2��</label>
			<label><input name="score" type="radio" value="3" />3��</label>
			<label><input name="score" type="radio" value="4" />4��</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5��</label>
			<input type="submit" value="����"/>
			<input type="hidden" value ="${film.filmID}" name = "filmID"/>
		</form>
	<%} else{%><font color="red">${requestScope.error }</font>
	<label class = "watch">��������:<%=watchDao.findWatch(filmID, userID).getScore() %></label>
	<%} }%>
		<h2>���ݼ��:</h2>
		<p class="brief">${film.filmInfo}</p>
	</div>
	
	

	<div class="comment">
		<h2>��������</h2>
		<c:forEach items="${requestScope.commentList1}" var="comment">
			<div class="commentInfo">
				${comment.commentTitle }:
				${comment.commentContent}
				<div class="commentuserInfo">
					�ظ���:${comment.userID} 
			  		ʱ��:${comment.publishTime}
			  		<font color="red">${requestScope.error1 }</font>
			  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=1">��ͬ</a>
			  		${comment.commentApprove}
			  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=0">����</a>
			  	</div>
		  	</div>
		</c:forEach>
		
		<h2>��������</h2>
		<c:forEach items="${requestScope.commentList2}" var="comment">
			<div class="commentInfo">
				${comment.commentTitle }:
				${comment.commentContent}
			</div>
			<div class="commentuserInfo">
				�ظ���:${comment.userID} 
		  		ʱ��:${comment.publishTime}
		  		<font color="red">${requestScope.error1 }</font>
		  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=1">��ͬ</a>
		  		${comment.commentApprove}
		  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=0">����</a>
		  	</div>
		</c:forEach>
		
		
		
		
		<div class="commentBox">
			<form action="AddFilmComment" method="post">
				<p>����:<input name = "commenttitle" type = "text"></p>
				<p>����:</p>
				<p>
					<FCK:editor instanceName="commentcontent" basePath="/fckeditor" toolbarSet="myToolbar" height="400" width="750"></FCK:editor>
				</p>
				<input type="hidden" name="filmID" value="${film.filmID}"/> 
				<p><input value = "�ύ" type = "submit"></p>
			</form>
		
		</div>
	</div>
</body>
</html>