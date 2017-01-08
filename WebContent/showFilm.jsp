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
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/showfilm.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script language="javascript">
function firm(commentID,userID){
	if(confirm("您确定要删除该条评论吗，这样会删除您所收到的赞数")){
		location.href="DeleteFilmComment?commentID="+commentID+"&userID="+userID; 
	}
	else{
		alert("取消删除");
	}
}
</script>
<title>电影信息</title>
</head>
<body>
<%@include file = "header.jsp" %> 
	<div class = "filmInfo">
		<h2>${film.filmName}</h2>
		<div class="Infodisplay" >
			<img src="${film.filmCoverPath }">
			<ul>
				<li>导演:${film.filmDirector}</li>
				<li>分类:${film.filmType}</li>
				<li>观看人数:${film.filmWatch }</li>
				<li>评分:${film.filmScore }</li>
			</ul>
		</div>
		
		
		<%
			Film film = (Film)request.getAttribute("film");
			User user = (User)session.getAttribute("user");
			if(user==null){
		%>
		<form action="ModifyWatchNum" method="post" class="watch">
			<label><input name="score" type="radio" value="1" />1分</label>
			<label><input name="score" type="radio" value="2" />2分</label>
			<label><input name="score" type="radio" value="3" />3分</label>
			<label><input name="score" type="radio" value="4" />4分</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5分</label>
			<input type="submit" value="看过"/>
			<input type="hidden" value ="${film.filmID}" name = "filmID"/>
		</form>
	<%}else{
			WatchDao watchDao = WatchDaoFactory.getWatchDaoInstance();
			int filmID = film.getFilmID();
			int userID = user.getUserID();
			if(watchDao.findWatch(filmID, userID)==null){
	%>
		<form action="ModifyWatchNum" method="post" class="watch">
			<label><input name="score" type="radio" value="1" />1分</label>
			<label><input name="score" type="radio" value="2" />2分</label>
			<label><input name="score" type="radio" value="3" />3分</label>
			<label><input name="score" type="radio" value="4" />4分</label>
			<label><input name="score" type="radio" value="5" checked="checked" />5分</label>
			<input type="submit" value="看过"/>
			<input type="hidden" value ="${film.filmID}" name = "filmID"/>
		</form>
	<%} else{%><font color="red">${requestScope.error }</font>
	<label class = "watch">您的评分:<%=watchDao.findWatch(filmID, userID).getScore() %></label>
	<%} }%>
		<h2>内容简介:</h2>
		<p class="brief">${film.filmInfo}</p>
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
			  		<c:choose>
			  			<c:when test="${empty sessionScope.user}">
			  			</c:when>
			  			<c:otherwise>
			  				<c:if test="${comment.userID == sessionScope.user.userID}"  >
			  					<input type="submit" name="Submit2" value="删除评论" onclick="firm(${comment.commentID},${comment.userID})" />
			  				</c:if>
			  			</c:otherwise>
			  		</c:choose>
			  		<font color="red">${requestScope.error }</font>
			  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=1">赞同</a>
			  		${comment.commentApprove}
			  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=0">反对</a>
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
		  		<c:choose>
			  		<c:when test="${empty sessionScope.user}">
			  		</c:when>
			  		<c:otherwise>
			  			<c:if test="${comment.userID == sessionScope.user.userID}"  >
			  				<input type="submit" name="Submit2" value="删除评论" onclick="firm(${comment.commentID},${comment.userID})" />
			  			</c:if>
			  		</c:otherwise>
			  	</c:choose>
		  		<font color="red">${requestScope.error }</font>
		  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=1">赞同</a>
		  		${comment.commentApprove}
		  		<a href="ModifyFilmApproveNum?commentID=${comment.commentID}&action=0">反对</a>
		  	</div>
		</c:forEach>
		
		
		
		
		<div class="commentBox">
			<form action="AddFilmComment" method="post">
				<p>标题:<input name = "commenttitle" type = "text"></p>
				<p>内容:</p>
				<textarea cols="80" rows="10" name="commentcontent">你有什么想说的</textarea>
					<script type="text/javascript">CKEDITOR.replace( "commentcontent",{
						width:950,height:300,
						toolbar :'basic'});
					</script>
				<input type="hidden" name="filmID" value="${film.filmID}"/> 
				<p><input value = "提交" type = "submit"></p>
			</form>
		
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>