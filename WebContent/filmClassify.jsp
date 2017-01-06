<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.FilmCommentDaoFactory" language="java"%>
<%@page import="dao.FilmCommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="bean.FilmComment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/filmpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>${film.filmType}</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	
	
	<div class="content">
		<%@include file = "filmSideBar.jsp"%>
	
	
		<div class="classmain">
			<c:choose>
				<c:when test="${empty requestScope.filmClassify}" >
					<h1>该分类还没有电影</h1>	
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.filmClassify}" var="film">
						<li id="filmclassify">
							<div><a href = "ShowFilm?filmID=${film.filmID }"><img src="${film.filmCoverPath}"/></a></div>
							<div class = "detail">片名:<a href = "ShowFilm?filmID=${film.filmID }">${film.filmName }</a></div>
							<div class = "detail">导演:${film.filmDirector }</div>
							<div class = "detail">评分:${film.filmScore }</div>
							<div class = "detail">已看人数:${film.filmWatch }</div>
						</li>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>