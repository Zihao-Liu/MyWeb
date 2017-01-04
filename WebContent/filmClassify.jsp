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
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<link href="filmpage.css" type="text/css" rel="stylesheet" media="all" />
<title>${film.filmType}</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	
	
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
				<ul>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("科幻", "utf-8") %>">科幻</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("悬疑", "utf-8") %>">悬疑</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("恐怖", "utf-8") %>">恐怖</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("动画", "utf-8") %>">动画</a></li>
				</ul>
				<ul>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("历史", "utf-8") %>">历史</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("剧情", "utf-8") %>">剧情</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>观看排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByWatch();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserWatch() %>部</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>点赞排名</h2>
				<ul>
					<%
						users = userDao.findAllUserOrderByApprove();
						i=0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserApprove() %></div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="hotcomment">
				<h2>热门评论</h2>
				<ul>
					<%
						FilmCommentDao filmCommentDao = FilmCommentDaoFactory.getCommentDaoInstance();
						List<FilmComment> filmComments = filmCommentDao.findCommentOrderByApprove();
						i = 0;
						for(FilmComment filmComment:filmComments){
					%> 
							<li class = "comment">
								<div><%=filmComment.getCommentTitle() %></div>
								<div><a href = "ShowFilm?filmID=<%=filmComment.getFilmID()%>"><%=filmComment.getCommentContent() %></a></div>
								<div>点赞数:<%=filmComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	
	
		<div class="main">
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
</body>
</html>