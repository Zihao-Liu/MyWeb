<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/index.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/personalinfo.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>��ע�б�</title>
</head>
<body>
	<%@include file = "header.jsp" %> 
	<div id="follow">
		<h2><label>�û�����</label>${userNew.userName}</h2>
		<div class = "followList">
			<h2>��ע</h2>	
			<c:choose>
				<c:when test="${empty requestScope.followingList }">
				û�й�ע����
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.followingList}" var="following">
						 <div><a href = "ShowUser?userID=${following.userID }">�û���${following.userName }</a></div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			<h2>��˿</h2>
			<c:choose>
				<c:when test="${empty requestScope.followerList }">
				û�з�˿
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.followerList}" var="follower">
						 <div><a href = "ShowUser?userID=${follower.userID }">�û���:${follower.userName }</a></div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<%@include file = "footer.jsp"%>
</body>
</html>