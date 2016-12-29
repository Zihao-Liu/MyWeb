<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.CommentDaoFactory" language="java"%>
<%@page import="factory.StatusDaoFactory" language="java"%>
<%@page import="dao.CommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="dao.StatusDao" language="java"%>
<%@page import="bean.Comment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="bean.Status" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="index.css" type="text/css" rel="stylesheet" media="all" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>主页</title>
</head>
<body>
	
	<%@include file = "header.jsp"%>
	<div id ="top">
		<form action="AddStatus" method="post">
			<textarea cols="80" rows="10" name="statusContent">你有什么想说的</textarea>
			<script type="text/javascript">CKEDITOR.replace( "statusContent",{
				width:950,height:60,
				toolbar :
				    [
						['Image','Link']
				    ]});</script>
				    <input type="submit" value="发布">
		</form>
	</div>
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>图书分类</h2>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("小说", "utf-8") %>">小说</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("戏剧", "utf-8") %>">戏剧</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("散文", "utf-8") %>">散文</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("漫画", "utf-8") %>">漫画</a></li>
				</ul>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("历史", "utf-8") %>">历史</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("哲学", "utf-8") %>">哲学</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>阅读排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserRead() %>本</div>
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
						CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
						List<Comment> comments = commentDao.findCommentOrderByApprove();
						i = 0;
						for(Comment comment:comments){
					%> 
							<li class = "comment">
								<div><%=comment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=comment.getBookID()%>"><%=comment.getCommentContent() %></a></div>
								<div>点赞数:<%=comment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	
	
		<div class="main">
			<div class="recommendbyscore">
				<h2>最新动态</h2>
				<ul>
					<%
						StatusDao statusDao= StatusDaoFactory.getStatusDaoInstance();
						List<Status> statuss = statusDao.findAllStatus();
						for(Status status:statuss){
					%> 
					<li class = "status">
						<div><%=status.getStatusContent()%></div>
						<div class="user">作者:<a href = "ShowUser?userID=<%=status.getUserID()%>"><%=userDao.findUserByID(status.getUserID()).getUserName()%></a></div>
						<div><%=status.getPublishTime() %></div>
					</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
	
		
</body>
</html>