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
<link href="filmpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<title>电影</title>
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
			<div class="recommendbytime">
				<h2>新片速递</h2>
				<ul>
					<%
						FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
						List<Film> films = filmDao.findAllFilmOrderByTime(); 
						i=0;
						for(Film film:films){
					%>
							<li class = "film">
								<div><a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><img src="<%=film.getFilmCoverPath()%>"/></a></div>
								<div>片名:<a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><%=film.getFilmName() %></a></div>
								<div>导演:<%=film.getFilmDirector() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="recommendbyhot">
				<h2>最受关注</h2>
				<ul>
					<%
						films = filmDao.findAllFilmOrderByWatch(); 
						i=0;
						for(Film film:films){
					%>
							<li class = "film">
								<div><a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><img src="<%=film.getFilmCoverPath()%>"/></a></div>
								<div>片名:<a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><%=film.getFilmName() %></a></div>
								<div>导演:<%=film.getFilmDirector() %></div>
								<div>已看人数:<%=film.getFilmWatch() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="recommendbyscore">
				<h2>评分最高</h2>
				<ul>
					<%
						films = filmDao.findAllFilmOrderByScore();
						i=0;
						for(Film film:films){
					%>
							<li class = "film">
								<div><a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><img src="<%=film.getFilmCoverPath()%>"/></a></div>
								<div>片名:<a href = "ShowFilm?filmID=<%=film.getFilmID()%>"><%=film.getFilmName() %></a></div>
								<div>导演:<%=film.getFilmDirector() %></div>
								<div>评分:<%=film.getFilmScore() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>