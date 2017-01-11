<%@page import="daoImpl.FilmDaoImpl" language="java"%>
<%@page import="factory.FilmDaoFactory" language="java"%>
<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.FilmCommentDaoFactory" language="java"%>
<%@page import="dao.FilmDao" language="java"%>
<%@page import="dao.FilmCommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="bean.Film" language="java"%>
<%@page import="bean.FilmComment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/filmpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>已看电影</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<%@include file = "filmSideBar.jsp"%>
	
	
		<div class="main">
			<div class="allfilm">
				<h2>他的影单</h2>				
				<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm" >
					<li class = "film">
						<div><img src="${userwatchfilm.filmCoverPath}"/></div>
						<div><a href = "ShowFilm?filmID=${userwatchfilm.filmID}">${userwatchfilm.filmName }</a></div>
						<div>${userwatchfilm.filmDirector}</div>
					</li>
				</c:forEach>
			</div>
			
			
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>