<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.BookCommentDaoFactory" language="java"%>
<%@page import="dao.BookCommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="bean.BookComment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="header.css" type="text/css" rel="stylesheet" media="all" />
<link href="bookpage.css" type="text/css" rel="stylesheet" media="all" />
<title>${book.bookType}</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	
	
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
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
						BookCommentDao bookCommentDao = BookCommentDaoFactory.getCommentDaoInstance();
						List<BookComment> bookComments = bookCommentDao.findCommentOrderByApprove();
						i = 0;
						for(BookComment bookComment:bookComments){
					%> 
							<li class = "comment">
								<div><%=bookComment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=bookComment.getBookID()%>"><%=bookComment.getCommentContent() %></a></div>
								<div>点赞数:<%=bookComment.getCommentApprove() %></div>
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
				<c:when test="${empty requestScope.bookClassify}" >
					<h1>该分类还没有图书</h1>	
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.bookClassify}" var="book">
						<li id="bookclassify">
							<div><a href = "ShowBook?bookID=${book.bookID }"><img src="${book.bookCoverPath}"/></a></div>
							<div class = "detail">书名:<a href = "ShowBook?bookID=${book.bookID }">${book.bookName }</a></div>
							<div class = "detail">作者:${book.bookAurthor }</div>
							<div class = "detail">评分:${book.bookScore }</div>
							<div class = "detail">已读人数:${book.bookRead }</div>
						</li>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
</body>
</html>