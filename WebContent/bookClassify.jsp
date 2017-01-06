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
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/bookpage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>${book.bookType}</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	
	
	<div class="content">
		<%@include file = "bookSideBar.jsp"%>
	
	
		<div class="classmain">
			<c:choose>
				<c:when test="${empty requestScope.bookClassify}" >
					<h1>该分类还没有图书</h1>	
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.bookClassify}" var="book">
						<li id="bookclassify">
							<div><a href = "ShowBook?bookID=${book.bookID }"><img src="${book.bookCoverPath}"/></a></div>
							<div class = "detail">书名:<a href = "ShowBook?bookID=${book.bookID }">${book.bookName }</a></div>
							<div class = "detail">作者:${book.bookAuthor }</div>
							<div class = "detail">评分:${book.bookScore }</div>
							<div class = "detail">已读人数:${book.bookRead }</div>
						</li>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>