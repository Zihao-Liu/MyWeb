<%@page import="factory.UserDaoFactory"%>
<%@page import="bean.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/showletter.css" type="text/css" rel="stylesheet" media="all" />
<title>所有私信</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="letter">
		<c:forEach items="${requestScope.letters}" var="letter">
			<c:choose>
				<c:when test="${letter.letterRead==0 }">
					<li id="letterinfo" >
						<div class = "detail" style="color:red;">未读</div>
						<div class = "detail" style="color:red;"><a href = "ShowLetter?letterID=${letter.letterID }">${letter.letterContent }</a></div>
						<div class = "detail">发送人:<a href = "ShowUser?userID=${letter.sendUserID }">${letter.sendUserID }</a></div>
						<div class = "detail">发送日期:${letter.letterSendTime }</div>
					</li>	
				</c:when>
				<c:otherwise>
					<li id="letterinfo" >
						<div class = "detail"><a href = "ShowLetter?letterID=${letter.letterID }">${letter.letterContent }</a></div>
						<div class = "detail">发送人:<a href = "ShowUser?userID=${letter.sendUserID }">${letter.sendUserID }</a></div>
						<div class = "detail">发送日期:${letter.letterSendTime }</div>
					</li>	
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
	<%@include file = "footer.jsp"%>
</body>
</html>